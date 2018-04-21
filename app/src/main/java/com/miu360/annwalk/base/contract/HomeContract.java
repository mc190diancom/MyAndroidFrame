package com.miu360.annwalk.base.contract;

import com.miu360.annwalk.base.BasePresenter;

/**
 * Created by Murphy on 2018/4/21.
 * 主页的contract，展示v和p的所有方法
 */

public interface HomeContract {
    interface View extends BaseView{
        void showView(String content);
    }

    interface Presenter extends BasePresenter<View> {
        void getShowData();
    }
}
