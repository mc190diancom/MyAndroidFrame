package com.miu360.annwalk.base.contract;

import com.miu360.annwalk.base.BasePresenter;
import com.miu360.annwalk.base.BaseView;

/**
 * Created by Murphy on 2018/2/1.
 * 登录界面的Contract，展示v和p的所有方法
 */

public interface MineContract {
    interface View extends BaseView {
        void showView(String content);
    }

    interface Presenter extends BasePresenter<View> {
        void getShowData();
    }
}
