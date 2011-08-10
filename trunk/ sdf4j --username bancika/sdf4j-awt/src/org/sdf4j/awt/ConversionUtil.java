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
			return new org.sdf4j.core.Stroke(bs.getLineWidth(), bs.getEndCap(), bs.getLineJoin(),
					bs.getMiterLimit(), bs.getDashArray(), bs.getDashPhase());
		}
		throw new IllegalArgumentException("Only BasicStroke instance are recognized.");
	}

	public static java.awt.Font convertFont(org.sdf4j.core.Font f) {
		return new java.awt.Font(f.getName(), f.getSize(), f.getStyle());
	}

	public static org.sdf4j.core.Font convertFont(java.awt.Font f) {
		return new org.sdf4j.core.Font(f.getName(), f.getSize(), f.getStyle());
	}

	public static java.awt.geom.AffineTransform convertAffineTransform(
			org.sdf4j.core.AffineTransform tx) {
		return new java.awt.geom.AffineTransform(tx.getM00(), tx.getM10(), tx.getM01(),
				tx.getM11(), tx.getM02(), tx.getM12());
	}

	public static org.sdf4j.core.AffineTransform convertAffineTransform(
			java.awt.geom.AffineTransform tx) {
		double[] flatMatrix = new double[6];
		tx.getMatrix(flatMatrix);
		return new org.sdf4j.core.AffineTransform(flatMatrix[0], flatMatrix[1], flatMatrix[2],
				flatMatrix[3], flatMatrix[4], flatMatrix[5]);
	}
}
