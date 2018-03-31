package com.example.mymvpdemo.ui.presenter;

import android.nfc.Tag;

import com.example.mymvpdemo.ui.base.BaseActivity;
import com.example.mymvpdemo.ui.base.BasePresenter;
import com.example.mymvpdemo.ui.view.ILoginView;
import com.example.mymvpdemo.util.LogUtils;
import com.example.mymvpdemo.util.UIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 登陆Presenter
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    public LoginPresenter(BaseActivity context) {
        super(context);
    }

    public void Login() {
        String phone = getView().getPhone().getText().toString().trim();
        String password = getView().getPassWord().getText().toString().trim();
        LogUtils.e("ddkklg");
        /**
         * 订阅者是 observer观察者的扩展，实现除了基本功能以外的
         */
        Subscriber<String> subscriber1 = new Subscriber<String>() {

            @Override
            public void onCompleted() {

                LogUtils.d("rxjava:subscriber" + "completed");
                UIUtils.showToast("rxjava:subscriber" + "completed");
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.d("rxjava:subscriber" + e.toString());
                UIUtils.showToast("rxjava:subscriber" + e.toString());
            }

            @Override
            public void onNext(String s) {
                LogUtils.d("rxjava:subscriber" + s);
                UIUtils.showToast("rxjava:subscriber" + s);
            }
        };
        /**
         * 正常的create方式
         */
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("111");
                subscriber.onNext("123");
                subscriber.onCompleted();
            }
        });
        /**
         * 将传入的参数依次发送出来
         */
        Observable observable2 = Observable.just("Hello", "Hi", "Aloha");
        // 将会依次调用：
// onNext("Hello");
// onNext("Hi");
// onNext("Aloha");
// onCompleted();
/**
 * 将传入的参数依次发送出来
 */
        List<Integer> a = new ArrayList<>();
        /**
         *  继承Iterable<E>或者数组T[]都可以
         */
        String[] words = {"Hello", "Hi", "Aloha","zzz"};
        Observable observable3 = Observable.from(words);
        // 将会依次调用：
// onNext("Hello");
// onNext("Hi");
// onNext("Aloha");
// onCompleted();
        /**
         * 订阅 实际会调用
         *  //  subscriber.onStart();
        //   onSubscribe.call(subscriber);
         一个订阅者只能订阅一个被观察者，先订阅的先实现
         */

//        observable.subscribe(subscriber1);
//        observable2.subscribe(subscriber1);
//        observable3.subscribe(subscriber1);

        Action1<String> onNext=new Action1<String>(){

            @Override
            public void call(String s) {
                LogUtils.d("dd"+s);
            }
        };
        Action1<Throwable> onError=new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                LogUtils.d("dd:error");
            }
        };
        Action0 onComple=new Action0() {
            @Override
            public void call() {
                LogUtils.d("dd:comple");
            }
        };
        observable.subscribe(onNext,onError,onComple);
       Observable.create(new Observable.OnSubscribe<String>(){

            @Override
            public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("aaa");
                subscriber.onNext("bb");
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())//生产所在线程
               .observeOn(AndroidSchedulers.mainThread())//消费所在线程
               .subscribe(new Action1<String>() {
                   @Override
                   public void call(String s) {
                              LogUtils.d("onNext"+s);
                   }
               });

    Observable.just("Hello", "Hi", "Aloha")
            .map(new Func1<String,Integer>(){

                @Override
                public Integer call(String s) {
                    return -1;
                }//map用于将just给的参数转成 Func1返回的值最终观察的是返回的值integer
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Subscriber<Integer>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Integer integer) {

                }
            });

    }
}
