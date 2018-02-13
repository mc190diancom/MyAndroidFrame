package com.miu360.annwalk.ui.activity;

import android.databinding.DataBindingUtil;
import com.miu360.annwalk.R;
import com.miu360.annwalk.base.BaseActivity;
import com.miu360.annwalk.base.contract.MainContract;
import com.miu360.annwalk.databinding.ActivityMainBinding;
import com.miu360.annwalk.presenter.MainPresenter;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{
    private ActivityMainBinding mBinding;

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void getLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void initEventAndData() {
        super.initEventAndData();
        mPresenter.getUserInfo();
    }

    @Override
    public void getUserName(String name) {
        mBinding.username.setText(name);
    }

    @Override
    public void getUserBirth(String birth) {
        mBinding.password.setText(birth);
    }

    @Override
    public void getUserFailed(String msg) {

    }


}
