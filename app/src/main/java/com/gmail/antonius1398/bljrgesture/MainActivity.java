package com.gmail.antonius1398.bljrgesture;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.MAGENTA;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class MainActivity extends AppCompatActivity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
    private TextView gestureText;
    private TextView output_text;
    private GestureDetectorCompat gDetector;
    public static final int SWIPE_THRESHOLD = 100;
    public static final int SWIPE_VELOCITY_THRESHOLD = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureText = (TextView) findViewById(R.id.gestureStatusText);
        output_text = (TextView) findViewById(R.id.gestureStatusText);
        this.gDetector = new GestureDetectorCompat(this, this);
        gDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(BLACK);
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(GREEN);
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureText.setText("onDoubleTapEvent");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(GRAY);
        return false;
    }

    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText("ondown");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(BLUE);
        return false;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(YELLOW);

    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(RED);
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        RelativeLayout layout=(RelativeLayout) findViewById(R.id.warna);
        layout.setBackgroundColor(MAGENTA);
        return false;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureText.setText("onFling");
        //return false;
        boolean result = false;
        float diffY = e2.getY() - e1.getY();
        float diffX = e2.getX() - e1.getX();
        if (Math.abs(diffX) > Math.abs(diffY)) {
            if (Math.abs(diffX) > SWIPE_THRESHOLD
                    && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    output_text.setText("onSwipeRight");
                } else {
                    output_text.setText("onSwipeLift");
                }
                result = true;
            }
        } else {
            if (Math.abs(diffY) > SWIPE_THRESHOLD
                    && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    output_text.setText("onSwipeBottom");
                } else {
                    output_text.setText("onSwipeup");
                }

            result = true;
        }
    }
    return result;
}
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
