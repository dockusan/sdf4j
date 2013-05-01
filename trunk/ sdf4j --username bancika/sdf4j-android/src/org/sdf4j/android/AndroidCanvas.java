package org.sdf4j.android;

import java.awt.geom.CubicCurve2D;

import org.sdf4j.core.Color;
import org.sdf4j.core.Font;
import org.sdf4j.core.FontMetrics;
import org.sdf4j.core.ICanvas;
import org.sdf4j.core.Image;
import org.sdf4j.core.Point;
import org.sdf4j.core.Stroke;
import org.sdf4j.core.shapes.CompositeShape;
import org.sdf4j.core.shapes.Rectangle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;

/**
 * {@link ICanvas} implementation for Android platform. Wraps around the
 * provided {@link Canvas} instance and delegates all calls to it.
 * 
 * @author Branislav Stojkovic
 */
public class AndroidCanvas implements ICanvas {

	private Canvas canvas;
	private Paint paint = new Paint();

	// Cached values, we can't get them back from the Paint object.
	private float[] strokeIntervals;
	private float strokePhase;
	private String fontName;

	public AndroidCanvas(Canvas canvas) {
		super();
		this.canvas = canvas;
	}

	@Override
	public Color getColor() {
		return new Color(paint.getColor());
	}

	@Override
	public void setColor(Color c) {
		paint.setColor(c.getRGB());
	}

	@Override
	public Font getFont() {
		return new Font(fontName, paint.getTypeface().getStyle(), (int) paint
				.getTextSize());
	}

	@Override
	public void setFont(Font f) {
		paint.setTextSize(f.getSize());
		paint.setTypeface(Typeface.create(f.getName(), f.getStyle()));
	}

	@Override
	public Stroke getStroke() {
		int cap;
		switch (paint.getStrokeCap()) {
		case BUTT:
			cap = Stroke.CAP_BUTT;
			break;
		case ROUND:
			cap = Stroke.CAP_ROUND;
			break;
		case SQUARE:
			cap = Stroke.CAP_SQUARE;
			break;
		default:
			throw new RuntimeException("Unrecognized cap value "
					+ paint.getStrokeCap());
		}
		int join;
		switch (paint.getStrokeJoin()) {
		case BEVEL:
			join = Stroke.JOIN_BEVEL;
			break;
		case MITER:
			join = Stroke.JOIN_MITER;
			break;
		case ROUND:
			join = Stroke.JOIN_ROUND;
			break;
		default:
			throw new RuntimeException("Unrecognized join value "
					+ paint.getStrokeJoin());
		}
		if (strokeIntervals != null) {
			return new Stroke(paint.getStrokeWidth(), cap, join, paint
					.getStrokeMiter(), strokeIntervals, strokePhase);
		} else {
			return new Stroke(paint.getStrokeWidth(), cap, join, paint
					.getStrokeMiter());
		}
	}

	@Override
	public void setStroke(Stroke s) {
		Cap cap;
		switch (s.getEndCap()) {
		case Stroke.CAP_BUTT:
			cap = Cap.BUTT;
			break;
		case Stroke.CAP_ROUND:
			cap = Cap.ROUND;
			break;
		case Stroke.CAP_SQUARE:
			cap = Cap.SQUARE;
			break;
		default:
			throw new IllegalArgumentException("Unrecognized cap value");
		}
		Join join;
		switch (s.getLineJoin()) {
		case Stroke.JOIN_BEVEL:
			join = Join.BEVEL;
			break;
		case Stroke.JOIN_MITER:
			join = Join.MITER;
			break;
		case Stroke.JOIN_ROUND:
			join = Join.MITER;
			break;
		default:
			throw new IllegalArgumentException("Unrecognized join value");
		}
		paint.setStrokeCap(cap);
		paint.setStrokeJoin(join);
		paint.setStrokeMiter(s.getMiterLimit());
		paint.setStrokeWidth(s.getLineWidth());
		paint.setPathEffect(new DashPathEffect(s.getDashArray(), s
				.getDashPhase()));
		this.strokeIntervals = s.getDashArray();
		this.strokePhase = s.getDashPhase();
	}

	@Override
	public void setAntiAlias(boolean antiAlias) {
		paint.setAntiAlias(antiAlias);
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		canvas.drawLine(x1, y1, x2, y2, paint);
	}

	@Override
	public void drawRect(int x, int y, int width, int height) {
		paint.setStyle(Style.STROKE);
		canvas.drawRect(x, y, x + width, y + height, paint);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		paint.setStyle(Style.FILL);
		canvas.drawRect(x, y, x + width, y + height, paint);
	}

	@Override
	public void drawRoundRect(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		paint.setStyle(Style.STROKE);
		canvas.drawRoundRect(new RectF(x, y, x + width, y + height), arcWidth,
				arcHeight, paint);
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height,
			int arcWidth, int arcHeight) {
		paint.setStyle(Style.FILL);
		canvas.drawRoundRect(new RectF(x, y, x + width, y + height), arcWidth,
				arcHeight, paint);
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		paint.setStyle(Style.STROKE);
		canvas.drawOval(new RectF(x, y, x + width, y + height), paint);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		paint.setStyle(Style.FILL);
		canvas.drawOval(new RectF(x, y, x + width, y + height), paint);
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		paint.setStyle(Style.STROKE);
		canvas.drawArc(new RectF(x, y, x + width, y + height), startAngle,
				arcAngle, false, paint);
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
		paint.setStyle(Style.FILL);
		canvas.drawArc(new RectF(x, y, x + width, y + height), startAngle,
				arcAngle, false, paint);
	}

	@Override
	public void drawString(String str, int x, int y) {
		canvas.drawText(str, x, y, paint);
	}

	@Override
	public void drawImage(Image image, int x, int y) {
		Bitmap bitmap = BitmapFactory.decodeByteArray(image.getData(), 0, image
				.getData().length);
		canvas.drawBitmap(bitmap, x, y, paint);
	}

	@Override
	public void saveTransform() {
		canvas.save();
	}

	@Override
	public void restoreTransform() {
		canvas.restore();
	}

	@Override
	public void rotate(double theta) {
		canvas.rotate((float) (theta * 180 / Math.PI));
	}

	@Override
	public void rotate(double theta, double x, double y) {
		canvas.rotate((float) (theta * 180 / Math.PI), (float) x, (float) y);
	}

	@Override
	public void scale(double sx, double sy) {
		canvas.scale((float) sx, (float) sy);
	}

	@Override
	public void translate(double dx, double dy) {
		canvas.translate((float) dx, (float) dy);
	}

	@Override
	public boolean containsPoint(IShape shape, Point point) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersectsRect(IShape shape, Rectangle rect) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FontMetrics getFontMetrics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getTextBounds(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void drawCurve(int x1, int y1, int ctrlx1, int ctrly1, int ctrlx2,
			int ctrly2, int x2, int y2) {
		Path path = new Path();
		path.moveTo(x1, y1);
		path.cubicTo(ctrlx1, ctrly1, ctrlx2, ctrly2, x2, y2);
		g2d.draw(path);
	}
}
