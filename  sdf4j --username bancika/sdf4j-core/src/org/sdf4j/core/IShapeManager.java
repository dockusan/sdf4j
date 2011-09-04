package org.sdf4j.core;

import org.sdf4j.core.shapes.CompositeShape;
import org.sdf4j.core.shapes.Rectangle;

public interface IShapeManager {

	boolean intersectsRect(CompositeShape shape, Rectangle rect);
	
	boolean containsPoint(CompositeShape shape, Point point);
}
