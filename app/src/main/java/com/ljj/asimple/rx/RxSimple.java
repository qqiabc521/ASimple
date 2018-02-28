package com.ljj.asimple.rx;

import android.util.Log;

import com.ljj.asimple.Config;

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

    public static void just(){
        Observable.just("1","2")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG," onSubscribe : " + d.isDisposed());
                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, " onNext : " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError :" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete" );
                    }
                });
    }
}
