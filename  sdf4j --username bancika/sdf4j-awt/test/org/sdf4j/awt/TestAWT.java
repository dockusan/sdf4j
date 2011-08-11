package org.sdf4j.awt;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.core.Test;

public class TestAWT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("AWT Test");
		JPanel p = new JPanel() {
			
			@Override
			public void paint(Graphics g) {
				Graphics2D g2d = (Graphics2D) g;
				AWTCanvas canvas = new AWTCanvas(g2d);
				Test.drawSample(canvas);
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
