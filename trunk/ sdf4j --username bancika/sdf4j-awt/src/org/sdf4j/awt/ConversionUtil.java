package org.sdf4j.awt;

import java.awt.BasicStroke;

public final class ConversionUtil {

	public static java.awt.Color convertColor(org.sdf4j.core.Color c) {
		return new java.awt.Color(c.getRGB());
	}

	public static org.sdf4j.core.Color convertColor(java.awt.Color c) {
		return new org.sdf4j.core.Color(c.getRGB());
	}

	public static java.awt.Stroke convertStroke(org.sdf4j.core.Stroke s) {
		return new java.awt.BasicStroke(s.getLineWidth(), s.getEndCap(), s.getLineJoin(), s
				.getMiterLimit(), s.getDashArray(), s.getDashPhase());
	}

	public static org.sdf4j.core.Stroke convertStroke(java.awt.Stroke s) {
		if (s instanceof BasicStroke) {
			BasicStroke bs = (BasicStroke) s;
			return new org.sdf4j.core.Stroke(bs.getLineWidth(), bs.getEndCap(),
					bs.getLineJoin(), bs.getMiterLimit(), bs.getDashArray(), bs.getDashPhase());
		}
		throw new IllegalArgumentException("Only BasicStroke instance are recognized.");
	}
	
	public static java.awt.Font convertFont(org.sdf4j.core.Font f) {
		return new java.awt.Font(f.getName(), f.getSize(), f.getStyle());
	}

	public static org.sdf4j.core.Font convertFont(java.awt.Font f) {
		return new org.sdf4j.core.Font(f.getName(), f.getSize(), f.getStyle());
	}
}
