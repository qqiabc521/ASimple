package com.ljj.asimple.rx;

import android.util.Log;

import com.ljj.asimple.Config;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lijunjie on 2018/2/28.
 */

public class RxSimple {
    public static final String TAG = Config.TAG + RxSimple.class.getSimpleName();

    private static Observer<Integer> getCommObserver(){
        return new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG," onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Integer s) {
                Log.i(TAG, " onNext : " + s.intValue());
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "onError :" + e);
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "onComplete" );
            }
        };
    }

    /**
     *  just( ) — 将一个或多个对象转换成发射这个或这些对象的一个Observable
     */
    public static void just(){
        Observable.just(1,2,3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getCommObserver());
    }

    public static void from(){
        Integer[] items = {1,2,3,4,5,6};
        Observable.fromArray(items)
                .subscribe(getCommObserver());
        Log.i(TAG, "=============================== fromIterable ===================" );
        Observable.fromIterable(Arrays.asList(1,2,3,4)).subscribe(getCommObserver());

    }
}
