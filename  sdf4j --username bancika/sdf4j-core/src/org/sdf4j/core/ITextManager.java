package org.sdf4j.core;

import org.sdf4j.core.shapes.Rectangle;

public interface ITextManager {

	FontMetrics getFontMetrics();
	
	Rectangle getTextBounds(String text);
}
