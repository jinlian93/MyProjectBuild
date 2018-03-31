package com.example.mymvpdemo.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.mymvpdemo.R;
import com.example.mymvpdemo.ui.activity.MainActivity;
import com.example.mymvpdemo.ui.base.BaseFragment;
import com.example.mymvpdemo.ui.presenter.MeFgPresenter;
import com.example.mymvpdemo.ui.view.IMeFgView;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @创建者 CSDN_LQR
 * @描述 我界面
 */
public class MeFragment extends BaseFragment<IMeFgView, MeFgPresenter> implements IMeFgView {


    @Override
    public void init() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView(View rootView) {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }





    @Override
    protected MeFgPresenter createPresenter() {
        return new MeFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_me;
    }


}
