package com.miu360.annwalk.base;

import android.view.ViewGroup;

import com.miu360.annwalk.app.App;
import com.miu360.annwalk.base.contract.BaseView;
import com.miu360.annwalk.di.component.ActivityComponent;
import com.miu360.annwalk.di.component.DaggerActivityComponent;
import com.miu360.annwalk.di.module.ActivityModule;
import com.miu360.annwalk.util.SnackbarUtil;

import javax.inject.Inject;

/**
 * Created by Murphy on 2018/2/1.
 * MVP activity基类
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {
    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule(){
        return new ActivityModule(this);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if (mPresenter != null)
            mPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void showErrorMsg(String msg) {
        //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected abstract void initInject();
}
