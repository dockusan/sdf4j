package org.sdf4j.awt;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import org.sdf4j.core.AffineTransform;
import org.sdf4j.core.Color;
import org.sdf4j.core.Font;
import org.sdf4j.core.ICanvas;
import org.sdf4j.core.Image;
import org.sdf4j.core.Stroke;

/**
 * {@link ICanvas} implementation for AWT {@link Graphics2D}. Wraps around the
 * specified {@link Graphics2D} object and delegates calls.
 * 
 * @author Branislav Stojkovic
 */
public class AWTCanvas implements ICanvas {

	private Graphics2D g2d;

	public AWTCanvas(Graphics2D g2d) {
		super();
		this.g2d = g2d;
	}

	@Override
	public Color getColor() {
		return ConversionUtil.convertColor(g2d.getColor());
	}

	@Override
	public void setColor(Color c) {
		g2d.setColor(ConversionUtil.convertColor(c));
	}

	@Override
	public Stroke getStroke() {
		return ConversionUtil.convertStroke(g2d.getStroke());
	}

	@Override
	public void setStroke(Stroke s) {
		g2d.setStroke(ConversionUtil.convertStroke(s));
	}

	@Override
	public Font getFont() {
		return ConversionUtil.convertFont(g2d.getFont());
	}

	@Override
	public void setFont(Font f) {
		g2d.setFont(ConversionUtil.convertFont(f));
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		g2d.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void drawRect(int x, int y, int width, int height) {
		g2d.drawRect(x, y, width, height);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		g2d.fillRect(x, y, width, height);
	}

	@Override
	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		g2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		g2d.drawOval(x, y, width, height);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		g2d.fillOval(x, y, width, height);
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		g2d.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		g2d.fillArc(x, y, width, height, startAngle, arcAngle);
	}

	@Override
	public void drawString(String str, int x, int y) {
		g2d.drawString(str, x, y);
	}

	@Override
	public void drawImage(Image img, int x, int y) {
		ImageIcon icon = new ImageIcon(img.getData());
		g2d.drawImage(icon.getImage(), x, y, null);
	}

	@Override
	public AffineTransform getTransform() {
		return ConversionUtil.convertAffineTransform(g2d.getTransform());
	}

	@Override
	public void setTransform(AffineTransform tx) {
		g2d.setTransform(ConversionUtil.convertAffineTransform(tx));
	}

	@Override
	public void transform(AffineTransform tx) {
		g2d.transform(ConversionUtil.convertAffineTransform(tx));
	}

	@Override
	public void rotate(double theta) {
		g2d.rotate(theta);
	}

	@Override
	public void rotate(double theta, double x, double y) {
		g2d.rotate(theta, x, y);
	}

	@Override
	public void scale(double sx, double sy) {
		g2d.scale(sx, sy);
	}

	@Override
	public void translate(int x, int y) {
		g2d.translate(x, y);
	}
}
