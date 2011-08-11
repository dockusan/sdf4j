package org.sdf4j;

import org.sdf4j.android.AndroidCanvas;
import org.slf4j.core.Test;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class AndroidTest extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new View(this) {
        	
        	@Override
        	protected void onDraw(Canvas canvas) {
        		AndroidCanvas androidCanvas = new AndroidCanvas(canvas);
        		Test.drawSample(androidCanvas);
        	}
        });
    }
}