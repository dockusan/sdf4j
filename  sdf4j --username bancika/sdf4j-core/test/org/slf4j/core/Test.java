package org.slf4j.core;

import org.sdf4j.core.Color;
import org.sdf4j.core.ICanvas;

public class Test {

	public static void drawSample(ICanvas canvas) {
		canvas.setAntiAlias(true);
		canvas.setColor(Color.red);
		canvas.fillOval(10, 10, 40, 40);
		canvas.setColor(Color.blue);
		canvas.drawOval(10, 10, 40, 40);
		canvas.drawLine(10, 10, 50, 50);
		canvas.saveTransform();
		canvas.rotate(Math.PI / 4, 80, 80);
		canvas.drawRect(65, 65, 30, 30);
		canvas.setColor(Color.yellow);
		canvas.fillRect(65, 65, 30, 30);
		canvas.restoreTransform();
		canvas.setColor(Color.black);
		canvas.drawString("test", 50, 20);
	}
}
