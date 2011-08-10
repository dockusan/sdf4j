package org.sdf4j.core;

public interface ITransformable {

	/**
	 * Composes an <code>AffineTransform</code> object with the
	 * <code>Transform</code> in this <code>Graphics2D</code> according to the
	 * rule last-specified-first-applied. If the current <code>Transform</code>
	 * is Cx, the result of composition with Tx is a new <code>Transform</code>
	 * Cx'. Cx' becomes the current <code>Transform</code> for this
	 * <code>Graphics2D</code>. Transforming a point p by the updated
	 * <code>Transform</code> Cx' is equivalent to first transforming p by Tx
	 * and then transforming the result by the original <code>Transform</code>
	 * Cx. In other words, Cx'(p) = Cx(Tx(p)). A copy of the Tx is made, if
	 * necessary, so further modifications to Tx do not affect rendering.
	 * 
	 * @param tx
	 *            the <code>AffineTransform</code> object to be composed with
	 *            the current <code>Transform</code>
	 * @see #setTransform
	 * @see AffineTransform
	 */
	void transform(AffineTransform tx);

	/**
	 * Returns a copy of the current <code>Transform</code> in the
	 * <code>Graphics2D</code> context.
	 * 
	 * @return the current <code>AffineTransform</code> in the
	 *         <code>Graphics2D</code> context.
	 * @see #transform
	 * @see #setTransform
	 */
	AffineTransform getTransform();

	/**
	 * Overwrites the Transform in the <code>Graphics2D</code> context. WARNING:
	 * This method should <b>never</b> be used to apply a new coordinate
	 * transform on top of an existing transform because the
	 * <code>Graphics2D</code> might already have a transform that is needed for
	 * other purposes, such as rendering Swing components or applying a scaling
	 * transformation to adjust for the resolution of a printer.
	 * <p>
	 * To add a coordinate transform, use the <code>transform</code>,
	 * <code>rotate</code>, <code>scale</code>, or <code>shear</code> methods.
	 * The <code>setTransform</code> method is intended only for restoring the
	 * original <code>Graphics2D</code> transform after rendering, as shown in
	 * this example:
	 * 
	 * <pre>
	 * &lt;blockquote&gt;
	 * // Get the current transform
	 * AffineTransform saveAT = g2.getTransform();
	 * // Perform transformation
	 * g2d.transform(...);
	 * // Render
	 * g2d.draw(...);
	 * // Restore original transform
	 * g2d.setTransform(saveAT);
	 * &lt;/blockquote&gt;
	 * </pre>
	 * 
	 * @param tx
	 *            the <code>AffineTransform</code> that was retrieved from the
	 *            <code>getTransform</code> method
	 * @see #transform
	 * @see #getTransform
	 * @see AffineTransform
	 */
	void setTransform(AffineTransform tx);

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
	public abstract void translate(int x, int y);

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
	public abstract void rotate(double theta);

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
	public abstract void rotate(double theta, double x, double y);

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
	public abstract void scale(double sx, double sy);

}
