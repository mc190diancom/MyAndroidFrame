package com.miu360.annwalk.base.contract;

import com.miu360.annwalk.base.BasePresenter;
import com.miu360.annwalk.model.bean.User;

/**
 * Created by Murphy on 2018/2/12.
 * 主界面的Contract，展示v和p的所有方法
 */

public interface MainContract {
    interface View extends BaseView{
        //如果获取本地的用户名成功，调用这个方法
        void getUserName(String name);
        void getUserBirth(String birth);
        //如果获取本地的用户信息失败，调用这个方法
        void getUserFailed(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserInfo();
    }
}
