package org.sdf4j;

import org.sdf4j.android.AndroidCanvas;
import org.slf4j.core.Test;

import android.app.Activity;
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
        	}
        });
    }
}