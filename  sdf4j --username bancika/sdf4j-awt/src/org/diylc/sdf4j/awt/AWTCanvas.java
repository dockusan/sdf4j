package org.diylc.sdf4j.awt;

import java.awt.Graphics2D;

import org.diylc.sdf4j.core.Color;
import org.diylc.sdf4j.core.ICanvas;
import org.diylc.sdf4j.core.Stroke;

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
		return awt2sdfColor(g2d.getColor());
	}
	

	@Override
	public void setColor(Color c) {
		g2d.setColor(sdf2awtColor(c));
	}

	@Override
	public Stroke getStroke() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStroke(Stroke s) {
		// TODO Auto-generated method stub
		
	}

	private static java.awt.Color sdf2awtColor(org.diylc.sdf4j.core.Color c) {
		return new java.awt.Color(c.getRGB());
	}
	
	private static org.diylc.sdf4j.core.Color awt2sdfColor(java.awt.Color c) {
		return new org.diylc.sdf4j.core.Color(c.getRGB());
	}
}
