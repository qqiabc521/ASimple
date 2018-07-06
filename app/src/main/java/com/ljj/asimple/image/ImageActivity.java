package com.ljj.asimple.image;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.ljj.asimple.BaseActivity;
import com.ljj.asimple.R;

import java.io.IOException;

public class ImageActivity extends BaseActivity {


    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.image_iv);

        float density = this.getResources().getDisplayMetrics().density;
        Log.e(getLogTag(), "density :" + density);

        getBitmapByName("slide_bg_image.png");
        getBitmapByName("slide_bg_image.webp");

        getBitmapById("slide_bg_image_m", R.mipmap.slide_bg_image_m);
        getBitmapById("slide_bg_image_h", R.mipmap.slide_bg_image_h);
        getBitmapById("slide_bg_image_xh", R.mipmap.slide_bg_image_xh);
        getBitmapById("slide_bg_image_xxh", R.mipmap.slide_bg_image_xxh);
        getBitmapById("slide_bg_image_xxxh", R.mipmap.slide_bg_image_xxxh);
    }

    private Bitmap getBitmapByName(String name){
        Bitmap bitmap = null;
        AssetManager assetManager = getAssets();
        try {
            bitmap =  BitmapFactory.decodeStream(assetManager.open(name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i(getLogTag(), name + ": " + getBitmapSize(bitmap));
        return bitmap;
    }

    private Bitmap getBitmapById(String name, int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = false;

        BitmapFactory.decodeResource(getResources(), id, options);
        Log.i(getLogTag(), name + " : inTargetDensity: " + options.inTargetDensity + " ,density: " + options.inDensity);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), id);
        Log.i(getLogTag(), name + ": " + getBitmapSize(bitmap));
        return bitmap;
    }

    private int getBitmapSize(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return bitmap.getAllocationByteCount();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            return bitmap.getByteCount();
        } else {
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
    }
}
