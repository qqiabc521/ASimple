package com.ljj.asimple.dispatchtouchevent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.ljj.asimple.R;

import static com.ljj.asimple.dispatchtouchevent.Constants.TAG;

public class DispatchTouchEventActivity extends Activity implements View.OnTouchListener {

    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "MainActivity onCreate");
        setContentView(R.layout.activity_dispatch_touchevent);
        myView = findViewById(R.id.myview);
        myView.setOnTouchListener(DispatchTouchEventActivity.this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MainActivity dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "MainActivity onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MainActivity onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "MainActivity onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "MainActivity onTouchEvent ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MainActivity onTouchEvent ACTION_UP");
                break;
            default:
                Log.e(TAG, "MainActivity onTouchEvent " + event.getAction());
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "MainActivity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "MainActivity onPause");
        super.onPause();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.e(TAG, "MainActivity onTouch");
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "MainActivity onTouch ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "MainActivity onTouch ACTION_MOVE");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "MainActivity onTouch ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "MainActivity onTouch ACTION_UP");
                break;
            default:
                Log.e(TAG, "MainActivity onTouchEvent " + event.getAction());
                break;
        }
        return false;
    }

}