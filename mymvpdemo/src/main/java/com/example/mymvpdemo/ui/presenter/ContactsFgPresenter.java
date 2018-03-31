package com.example.mymvpdemo.ui.presenter;

import com.example.mymvpdemo.ui.base.BaseActivity;
import com.example.mymvpdemo.ui.base.BasePresenter;
import com.example.mymvpdemo.ui.view.IContactsFgView;
import com.example.mymvpdemo.ui.view.ILoginView;
import com.example.mymvpdemo.util.LogUtils;
import com.example.mymvpdemo.util.UIUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


/**
 * 我的联系Presenter
 */
public class ContactsFgPresenter extends BasePresenter<IContactsFgView> {

    public ContactsFgPresenter(BaseActivity context) {
        super(context);
    }


}
