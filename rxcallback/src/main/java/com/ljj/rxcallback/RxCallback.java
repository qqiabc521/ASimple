package com.ljj.rxcallback;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class RxCallback<T> implements Runnable{

    private static final Object TRIGGER = new Object();

    private CallbackHolder<T> callbackHolder;

    private PublishSubject<CallbackHolder<T>> subject;

    public static <T> Observable<CallbackHolder<T>> create(T t){

        return new RxCallback(t).createObservable();
    }

    private RxCallback(T t) {
        callbackHolder = new CallbackHolder<>(t);
    }

    private Observable<CallbackHolder<T>> createObservable(){
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<String, String>() {

            @Override
            public String apply(String s) throws Exception {
                return null;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        return Observable.just(callbackHolder);
    }

//    public Observable<CallbackHolder<T>> before(){
//
//    }


    @Override
    public void run() {

    }

    private static class CallbackHolder<T>{
        private final WeakReference<T> weakReference;

        public CallbackHolder(T t){
            weakReference = new WeakReference<>(t);
        }

        public T getSupport(){
            return weakReference.get();
        }
    }
}
