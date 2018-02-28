package com.ljj.asimple.rx;

import android.os.Bundle;
import android.view.View;

import com.ljj.asimple.BaseActivity;
import com.ljj.asimple.R;

public class RxActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
    }

    public void startRxJust(View view) {
        RxSimple.just();
    }
}
