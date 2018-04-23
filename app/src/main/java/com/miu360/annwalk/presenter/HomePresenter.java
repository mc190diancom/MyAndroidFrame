package com.miu360.annwalk.presenter;

import android.os.Handler;

import com.miu360.annwalk.base.RxPresenter;
import com.miu360.annwalk.base.contract.HomeContract;
import com.miu360.annwalk.model.DataManager;

import javax.inject.Inject;

/**
 * Created by Murphy on 2018/4/21.
 * 主页的present
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter{
   /* private DataManager mDataManager;
*/
    @Inject
    HomePresenter() {
    }

    @Override
    public void attachView(HomeContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getShowData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.showView("我是主页");
            }
        },1000);
    }
}
