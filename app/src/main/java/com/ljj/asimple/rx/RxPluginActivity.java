package com.ljj.asimple.rx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ljj.asimple.BaseActivity;
import com.ljj.asimple.R;

import java.io.IOError;
import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class RxPluginActivity extends BaseActivity {
    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_plugin);
    }

    public void startTask(View view) {
        disposable = Observable.just(1)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        Log.e(getLogTag(), "task next :" + integer.intValue());
//                         for(int i=0;i<100;i++){
//                             Log.i(getLogTag(),i+"");
//                             Thread.sleep(50);
//                         }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            throw new IOError(new IOException("io error"));
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e(getLogTag(), "task onComplete");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(getLogTag(), "task onError :" + throwable.getMessage());
                    }
                });

    }

    public void cancelTask(View view) {
        Log.e(getLogTag(), "cancelTask start");
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
            Log.e(getLogTag(), "cancelTask end");
        }
    }


}
