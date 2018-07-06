package com.ljj.asimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ljj.asimple.dispatchtouchevent.DispatchTouchEventActivity;
import com.ljj.asimple.image.ImageActivity;
import com.ljj.asimple.rx.RxActivity;
import com.ljj.asimple.rx.RxPluginActivity;
import com.ljj.asimple.ui.UIActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startRxSimple(View view) {
        startActivity(new Intent(this, RxActivity.class));
    }

    public void startRxPluginSimple(View view) {
        startActivity(new Intent(this, RxPluginActivity.class));
    }

    public void startUISimple(View view) {
        startActivity(new Intent(this, UIActivity.class));
    }

    public void startTouchEventSimple(View view) {
        startActivity(new Intent(this, DispatchTouchEventActivity.class));
    }

    public void startImageSimple(View view) {
        startActivity(new Intent(this, ImageActivity.class));
    }
}
