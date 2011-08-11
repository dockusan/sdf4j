package org.sdf4j.android;

import org.sdf4j.core.Color;
import org.sdf4j.core.Font;
import org.sdf4j.core.ICanvas;
import org.sdf4j.core.Image;
import org.sdf4j.core.Stroke;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Style;

public class AndroidCanvas implements ICanvas {

	private Canvas canvas;
	private Paint paint = new Paint();

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
		return null;
	}

	@Override
	public void setFont(Font f) {
	}

	@Override
	public Stroke getStroke() {
		return null;
	}

	@Override
	public void setStroke(Stroke s) {
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
	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		paint.setStyle(Style.STROKE);
		canvas.drawRoundRect(new RectF(x, y, x + width, y + height), arcWidth, arcHeight, paint);
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		paint.setStyle(Style.FILL);
		canvas.drawRoundRect(new RectF(x, y, x + width, y + height), arcWidth, arcHeight, paint);
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
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		paint.setStyle(Style.STROKE);
		canvas.drawArc(new RectF(x, y, x + width, y + height), startAngle, arcAngle, false, paint);
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		paint.setStyle(Style.FILL);
		canvas.drawArc(new RectF(x, y, x + width, y + height), startAngle, arcAngle, false, paint);
	}

	@Override
	public void drawString(String str, int x, int y) {
		canvas.drawText(str, x, y, paint);
	}

	@Override
	public void drawImage(Image image, int x, int y) {
		Bitmap bitmap = BitmapFactory.decodeByteArray(image.getData(), 0, image.getData().length);
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
}
