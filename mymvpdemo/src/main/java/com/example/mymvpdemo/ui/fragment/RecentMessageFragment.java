package com.example.mymvpdemo.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.mymvpdemo.R;
import com.example.mymvpdemo.ui.activity.MainActivity;
import com.example.mymvpdemo.ui.base.BaseFragment;
import com.example.mymvpdemo.ui.presenter.RecentMessageFgPresenter;
import com.example.mymvpdemo.ui.view.IRecentMessageFgView;


/**
 * @创建者 CSDN_LQR
 * @描述 最近会话列表界面
 */
public class RecentMessageFragment extends BaseFragment<IRecentMessageFgView, RecentMessageFgPresenter> implements IRecentMessageFgView {

    private boolean isFirst = true;

    @Override
    public void init() {

    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void initData() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }




    @Override
    protected RecentMessageFgPresenter createPresenter() {
        return new RecentMessageFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_recent_message;
    }


}
