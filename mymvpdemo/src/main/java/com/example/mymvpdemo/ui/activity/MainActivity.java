package com.example.mymvpdemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.mymvpdemo.R;
import com.example.mymvpdemo.ui.adapter.CommonFragmentPagerAdapter;
import com.example.mymvpdemo.ui.base.BaseActivity;
import com.example.mymvpdemo.ui.base.BaseFragment;
import com.example.mymvpdemo.ui.fragment.FragmentFactory;
import com.example.mymvpdemo.ui.presenter.MainPresenter;
import com.example.mymvpdemo.ui.view.IMainView;
import com.example.mymvpdemo.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<IMainView,MainPresenter> implements IMainView {
    private NoScrollViewPager noScrollViewPager;
    private RadioGroup radioGroup;
    private List<BaseFragment> mFragmentList = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public  void findView(){
        findViewById(R.id.nvp);
    }
    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
     radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
         @Override
         public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
             switch (checkedId) {
                 case R.id.rb_home:

                     noScrollViewPager.setCurrentItem(0, false);
                     break;
                 case R.id.rb_shop:

                     noScrollViewPager.setCurrentItem(1, false);
                     break;
                 case R.id.rb_customer:

                     noScrollViewPager.setCurrentItem(2, false);
                     break;
                 case R.id.rb_mine:

                     noScrollViewPager.setCurrentItem(3, false);
                     break;
             }
         }
     });
    }

    @Override
    public void initView() {
      noScrollViewPager=(NoScrollViewPager) findViewById(R.id.nvp);
       radioGroup=(RadioGroup) findViewById(R.id.rg_group);

        mFragmentList.add(FragmentFactory.getInstance().getRecentMessageFragment());
        mFragmentList.add(FragmentFactory.getInstance().getContactsFragment());
        mFragmentList.add(FragmentFactory.getInstance().getDiscoveryFragment());
        mFragmentList.add(FragmentFactory.getInstance().getMeFragment());
        noScrollViewPager.setAdapter(new CommonFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList));
        noScrollViewPager.setOffscreenPageLimit(4);

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }


}
