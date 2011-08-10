package org.sdf4j.awt;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import org.sdf4j.core.Color;
import org.sdf4j.core.Font;
import org.sdf4j.core.ICanvas;
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
		return convertColor(g2d.getColor());
	}

	@Override
	public void setColor(Color c) {
		g2d.setColor(convertColor(c));
	}

	@Override
	public Stroke getStroke() {
		return convertStroke(g2d.getStroke());
	}

	@Override
	public void setStroke(Stroke s) {
		g2d.setStroke(convertStroke(s));
	}
	
	@Override
	public Font getFont() {
		return convertFont(g2d.getFont());
	}
	
	@Override
	public void setFont(Font f) {
		g2d.setFont(convertFont(f));
	}

	private static java.awt.Color convertColor(org.sdf4j.core.Color c) {
		return new java.awt.Color(c.getRGB());
	}

	private static org.sdf4j.core.Color convertColor(java.awt.Color c) {
		return new org.sdf4j.core.Color(c.getRGB());
	}

	private static java.awt.Stroke convertStroke(org.sdf4j.core.Stroke s) {
		return new java.awt.BasicStroke(s.getLineWidth(), s.getEndCap(), s.getLineJoin(), s
				.getMiterLimit(), s.getDashArray(), s.getDashPhase());
	}

	private static org.sdf4j.core.Stroke convertStroke(java.awt.Stroke s) {
		if (s instanceof BasicStroke) {
			BasicStroke bs = (BasicStroke) s;
			return new org.sdf4j.core.Stroke(bs.getLineWidth(), bs.getEndCap(),
					bs.getLineJoin(), bs.getMiterLimit(), bs.getDashArray(), bs.getDashPhase());
		}
		throw new IllegalArgumentException("Only BasicStroke instance are recognized.");
	}
	
	private static java.awt.Font convertFont(org.sdf4j.core.Font f) {
		return new java.awt.Font(f.getName(), f.getSize(), f.getStyle());
	}

	private static org.sdf4j.core.Font convertFont(java.awt.Font f) {
		return new org.sdf4j.core.Font(f.getName(), f.getSize(), f.getStyle());
	}
}
