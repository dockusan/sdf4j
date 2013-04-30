package org.sdf4j.core.shapes;

import java.util.LinkedHashMap;
import java.util.Map;

public class CompositeShape implements IShape {

	private static final long serialVersionUID = 1L;
	
	// Use LinkedHashMap to preserve the order.
	Map<IShape, Operation> shapeMap = new LinkedHashMap<IShape, Operation>(); 

	public void add(IShape shape) {
		shapeMap.put(shape, Operation.ADD);
	}
	
	public void subtract(IShape shape) {
		shapeMap.put(shape, Operation.SUBTRACT);
	}
	
	public void clear() {
		shapeMap.clear();
	}
	
	public boolean isEmpty() {
		return shapeMap.isEmpty();
	}
	
	public Map<IShape, Operation> getShapeMap() {
		return shapeMap;
	}
}
