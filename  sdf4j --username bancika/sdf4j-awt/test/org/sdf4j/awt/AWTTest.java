package org.sdf4j.awt;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.core.Test;

/**
 * Runnable test class for AWT concrete implementation of SDF4J.
 * 
 * @author Branislav Stojkovic
 */
public class AWTTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("AWT Test");
		JPanel p = new JPanel() {

			@Override
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				// Wrap the graphics with the AWTCanvas.
				AWTCanvas awtCanvas = new AWTCanvas(g2d);
				// Call our generic drawing routine over the AWTCanvas.
				Test.drawSample(awtCanvas);
			}
		};
		p.setPreferredSize(new Dimension(200, 200));
		f.setContentPane(p);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
