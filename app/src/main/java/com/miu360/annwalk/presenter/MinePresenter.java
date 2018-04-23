package com.miu360.annwalk.presenter;

import android.os.Handler;

import com.miu360.annwalk.base.RxPresenter;
import com.miu360.annwalk.base.contract.MineContract;
import com.miu360.annwalk.model.DataManager;

import javax.inject.Inject;

/**
 * Created by Murphy on 2018/4/21.
 * 主页的present
 */

public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter{
   /* private DataManager mDataManager;
*/
    @Inject
    MinePresenter() {
    }

    @Override
    public void attachView(MineContract.View view) {
        super.attachView(view);
    }

    @Override
    public void getShowData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.showView("我是纵火犯");
            }
        },1000);
    }
}
