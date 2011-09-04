package org.sdf4j.awt;

import java.awt.BasicStroke;
import java.awt.geom.Area;
import java.util.Map;

import org.sdf4j.core.shapes.CompositeShape;
import org.sdf4j.core.shapes.IShape;
import org.sdf4j.core.shapes.Operation;

public final class ConversionUtil {

	public static java.awt.Color convertColor(org.sdf4j.core.Color c) {
		return new java.awt.Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}

	public static org.sdf4j.core.Color convertColor(java.awt.Color c) {
		return new org.sdf4j.core.Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
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
		return new java.awt.Font(f.getName(), f.getStyle(), f.getSize());
	}

	public static org.sdf4j.core.Font convertFont(java.awt.Font f) {
		return new org.sdf4j.core.Font(f.getName(), f.getStyle(), f.getSize());
	}

	public static java.awt.Shape convertShape(CompositeShape shape) {
		Area area = new Area();
		if (shape.isEmpty()) {
			return area;
		}
		if (shape.getShapeMap().size() == 1) {
			return convertShape(shape.getShapeMap().keySet().iterator().next());
		}
		for (Map.Entry<IShape, Operation> entry : shape.getShapeMap().entrySet()) {
			java.awt.Shape awtShape = convertShape(entry.getKey());
			if (entry.getValue() == Operation.ADD) {
				area.add(new Area(awtShape));
			} else {
				area.subtract(new Area(awtShape));
			}
		}
		return area;
	}

	public static java.awt.Shape convertShape(IShape shape) {
		if (shape instanceof org.sdf4j.core.shapes.Rectangle) {
			org.sdf4j.core.shapes.Rectangle rect = (org.sdf4j.core.shapes.Rectangle) shape;
			return new java.awt.geom.Rectangle2D.Double(rect.getX(), rect.getY(), rect.getWidth(),
					rect.getHeight());
		}
		if (shape instanceof org.sdf4j.core.shapes.Ellipse) {
			org.sdf4j.core.shapes.Ellipse rect = (org.sdf4j.core.shapes.Ellipse) shape;
			return new java.awt.geom.Ellipse2D.Double(rect.getX(), rect.getY(), rect.getWidth(),
					rect.getHeight());
		}
		throw new IllegalArgumentException("Could not recognize shape type: " + shape.getClass());
	}

	public static IShape convertShape(java.awt.Shape shape) {
		if (shape instanceof java.awt.geom.Rectangle2D) {
			java.awt.geom.Rectangle2D rect = (java.awt.geom.Rectangle2D) shape;
			return new org.sdf4j.core.shapes.Rectangle((int) rect.getX(), (int) rect.getY(),
					(int) rect.getWidth(), (int) rect.getHeight());
		}
		if (shape instanceof java.awt.geom.Ellipse2D.Double) {
			java.awt.geom.Ellipse2D.Double rect = (java.awt.geom.Ellipse2D.Double) shape;
			return new org.sdf4j.core.shapes.Ellipse((int) rect.getX(), (int) rect.getY(),
					(int) rect.getWidth(), (int) rect.getHeight());
		}
		throw new IllegalArgumentException("Could not recognize shape type: " + shape.getClass());
	}

	public static java.awt.Point convertPoint(org.sdf4j.core.Point point) {
		return new java.awt.Point(point.getX(), point.getY());
	}

	// public static java.awt.geom.AffineTransform convertAffineTransform(
	// org.sdf4j.core.AffineTransform tx) {
	// return new java.awt.geom.AffineTransform(tx.getM00(), tx.getM10(),
	// tx.getM01(),
	// tx.getM11(), tx.getM02(), tx.getM12());
	// }
	//
	// public static org.sdf4j.core.AffineTransform convertAffineTransform(
	// java.awt.geom.AffineTransform tx) {
	// double[] flatMatrix = new double[6];
	// tx.getMatrix(flatMatrix);
	// return new org.sdf4j.core.AffineTransform(flatMatrix[0], flatMatrix[1],
	// flatMatrix[2],
	// flatMatrix[3], flatMatrix[4], flatMatrix[5]);
	// }
}
