package com.miu360.annwalk.base.contract;

import com.miu360.annwalk.base.BasePresenter;
import com.miu360.annwalk.model.bean.User;

/**
 * Created by Murphy on 2018/2/1.
 * 登录界面的Contract，展示v和p的所有方法
 */

public interface LoginContract {
    interface View extends BaseView{
        //如果登录成功，调用这个方法
        void LoginSuccess(User user);
        //如果登录失败，调用这个方法
        void LoginFailed(String msg);
    }

    interface Presenter extends BasePresenter<View> {

    }
}
