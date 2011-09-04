package org.sdf4j.core;

/**
 * Interface that describes a canvas, regardless of its technology. Has methods
 * for drawing, transformations and color management.
 * 
 * @author Branislav Stojkovic
 */
public interface ICanvas extends IPaintingAttributeManager, IGeometryRenderer, IImageRenderer,
		ITransformable, IShapeManager, ITextManager {

}
