package org.sdf4j.core;

import org.sdf4j.core.shapes.IShape;
import org.sdf4j.core.shapes.Rectangle;

public interface IShapeManager {

	boolean intersectsRect(IShape shape, Rectangle rect);
	
	boolean containsPoint(IShape shape, Point point);
}
