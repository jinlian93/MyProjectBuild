package com.example.mymvpdemo.ui.fragment;


import com.example.mymvpdemo.R;
import com.example.mymvpdemo.ui.activity.MainActivity;
import com.example.mymvpdemo.ui.base.BaseFragment;
import com.example.mymvpdemo.ui.presenter.DiscoveryFgPresenter;
import com.example.mymvpdemo.ui.view.IDiscoveryFgView;

/**
 * @创建者 CSDN_LQR
 * @描述 发现界面
 */
public class DiscoveryFragment extends BaseFragment<IDiscoveryFgView, DiscoveryFgPresenter> implements IDiscoveryFgView {


    @Override
    public void initListener() {

    }

    @Override
    protected DiscoveryFgPresenter createPresenter() {
        return new DiscoveryFgPresenter((MainActivity) getActivity());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_discovery;
    }
}
