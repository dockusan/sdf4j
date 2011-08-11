package org.sdf4j.core;

public interface ITransformable {

	/**
	 * Saves the state of the transformation.
	 */
	void saveTransform();

	/**
	 * Restores the previously saved transformation state.
	 */
	void restoreTransform();

	/**
	 * Translates the origin of the <code>Graphics2D</code> context to the point
	 * (<i>x</i>,&nbsp;<i>y</i>) in the current coordinate system. Modifies the
	 * <code>Graphics2D</code> context so that its new origin corresponds to the
	 * point (<i>x</i>,&nbsp;<i>y</i>) in the <code>Graphics2D</code> context's
	 * former coordinate system. All coordinates used in subsequent rendering
	 * operations on this graphics context are relative to this new origin.
	 * 
	 * @param x
	 *            the specified x coordinate
	 * @param y
	 *            the specified y coordinate
	 * @since JDK1.0
	 */
	void translate(double x, double y);

	/**
	 * Concatenates the current <code>Graphics2D</code> <code>Transform</code>
	 * with a rotation transform. Subsequent rendering is rotated by the
	 * specified radians relative to the previous origin. This is equivalent to
	 * calling <code>transform(R)</code>, where R is an
	 * <code>AffineTransform</code> represented by the following matrix:
	 * 
	 * <pre>
	 * 	[   cos(theta)    -sin(theta)    0   ]
	 * 	[   sin(theta)     cos(theta)    0   ]
	 * 	[       0              0         1   ]
	 * </pre>
	 * 
	 * Rotating with a positive angle theta rotates points on the positive x
	 * axis toward the positive y axis.
	 * 
	 * @param theta
	 *            the angle of rotation in radians
	 */
	void rotate(double theta);

	/**
	 * Concatenates the current <code>Graphics2D</code> <code>Transform</code>
	 * with a translated rotation transform. Subsequent rendering is transformed
	 * by a transform which is constructed by translating to the specified
	 * location, rotating by the specified radians, and translating back by the
	 * same amount as the original translation. This is equivalent to the
	 * following sequence of calls:
	 * 
	 * <pre>
	 * translate(x, y);
	 * rotate(theta);
	 * translate(-x, -y);
	 * </pre>
	 * 
	 * Rotating with a positive angle theta rotates points on the positive x
	 * axis toward the positive y axis.
	 * 
	 * @param theta
	 *            the angle of rotation in radians
	 * @param x
	 *            the x coordinate of the origin of the rotation
	 * @param y
	 *            the y coordinate of the origin of the rotation
	 */
	void rotate(double theta, double x, double y);

	/**
	 * Concatenates the current <code>Graphics2D</code> <code>Transform</code>
	 * with a scaling transformation Subsequent rendering is resized according
	 * to the specified scaling factors relative to the previous scaling. This
	 * is equivalent to calling <code>transform(S)</code>, where S is an
	 * <code>AffineTransform</code> represented by the following matrix:
	 * 
	 * <pre>
	 * 	[   sx   0    0   ]
	 * 	[   0    sy   0   ]
	 * 	[   0    0    1   ]
	 * </pre>
	 * 
	 * @param sx
	 *            the amount by which X coordinates in subsequent rendering
	 *            operations are multiplied relative to previous rendering
	 *            operations.
	 * @param sy
	 *            the amount by which Y coordinates in subsequent rendering
	 *            operations are multiplied relative to previous rendering
	 *            operations.
	 */
	void scale(double sx, double sy);

}
