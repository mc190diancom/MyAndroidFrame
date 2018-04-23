package com.miu360.annwalk.ui.activity;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.miu360.annwalk.R;
import com.miu360.annwalk.base.BaseActivity;
import com.miu360.annwalk.base.contract.MainContract;
import com.miu360.annwalk.databinding.ActivityMainBinding;
import com.miu360.annwalk.databinding.FragmentMainBinding;
import com.miu360.annwalk.presenter.MainPresenter;
import com.miu360.annwalk.ui.adapter.MainAdapter;
import com.miu360.annwalk.ui.fragment.HomeFragment;
import com.miu360.annwalk.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{
    private FragmentMainBinding mBinding;
    List<Fragment> fragments = new ArrayList<>();
    FragmentPagerAdapter mAdapter;
    String[] tabTitle = new String[]{"主页","我的"};

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void getLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.fragment_main);
    }

    @Override
    protected void initEventAndData() {
        //mPresenter.getUserInfo();
        fragments.add(new HomeFragment());
        fragments.add(new MineFragment());
        mAdapter = new MainAdapter(getSupportFragmentManager(),fragments);
        mBinding.vpMain.setAdapter(mAdapter);
        mBinding.tabMain.addTab(mBinding.tabMain.newTab().setText(tabTitle[0]));
        mBinding.tabMain.addTab(mBinding.tabMain.newTab().setText(tabTitle[1]));
        mBinding.tabMain.setupWithViewPager(mBinding.vpMain);
        mBinding.tabMain.getTabAt(0).setText(tabTitle[0]);
        mBinding.tabMain.getTabAt(1).setText(tabTitle[1]);
    }

    @Override
    public void getUserName(String name) {
        //mBinding.username.setText(name);
    }

    @Override
    public void getUserBirth(String birth) {
        //mBinding.password.setText(birth);
    }

    @Override
    public void getUserFailed(String msg) {

    }


}
