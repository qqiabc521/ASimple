package com.ljj.asimple.flowview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljj.asimple.BaseActivity;
import com.ljj.asimple.R;

public class FlowViewActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowview);

        FlowView flowView = findViewById(R.id.flowview);

        for(int i=0;i<20;i++){
            TextView textView = new TextView(this);
            textView.setTextSize(30);
            textView.setTextColor(getResources().getColor(R.color.colorPrimary));
            textView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            flowView.addView(textView,layoutParams);
        }


    }
}
