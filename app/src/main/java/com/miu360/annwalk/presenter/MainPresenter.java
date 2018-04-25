package com.miu360.annwalk.presenter;

import com.miu360.annwalk.base.RxPresenter;
import com.miu360.annwalk.base.contract.MainContract;
import com.miu360.annwalk.model.DataManager;

import javax.inject.Inject;

/**
 * Created by Murphy on 2018/2/12.
 * 主页的presenter
 */

public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{
    private DataManager mDataManager;

    @Inject
    MainPresenter(DataManager mDataManager){
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getUserInfo() {
        mView.getUserName(mDataManager.getUserName());
        mView.getUserBirth(mDataManager.getUserBirth());
    }
}
