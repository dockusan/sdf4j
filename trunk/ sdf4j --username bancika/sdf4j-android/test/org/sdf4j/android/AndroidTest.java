package org.sdf4j.android;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.sdf4j.android.R;
import org.sdf4j.core.Image;
import org.slf4j.core.Test;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

/**
 * Runnable test class for Android concrete implementation of SDF4J.
 * 
 * @author Branislav Stojkovic
 */
public class AndroidTest extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set our own View.
		setContentView(new View(this) {

			@Override
			protected void onDraw(Canvas canvas) {
				// Wrap the canvas with Android canvas.
				AndroidCanvas androidCanvas = new AndroidCanvas(canvas);
				// Call our generic drawing routine over the AndroidCanvas.
				Test.drawSample(androidCanvas);
				
				Resources res = getResources();
				
				InputStream in = null;
				byte[] b = new byte[64000];
				int size = 0;
				try {
					in = res.openRawResource(R.drawable.icon);
					int c;

					while ((c = in.read()) != -1) {
						b[size++] = (byte) c;
					}
					b[size] = -1;
					Image i = new Image("test", b);
					androidCanvas.drawImage(i, 10, 60);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
	}
}