package com.miu360.annwalk.base.contract;

import com.miu360.annwalk.base.BasePresenter;
import com.miu360.annwalk.base.BaseView;
import com.miu360.annwalk.model.bean.User;

/**
 * Created by Murphy on 2018/2/1.
 * 登录界面的Contract，展示v和p的所有方法
 */

public interface LoginContract {
    interface View extends BaseView {
        //如果登录成功，调用这个方法
        void LoginSuccess(User user);
        //如果登录失败，调用这个方法
        void LoginFailed(String msg);
        //进度条完成后，进行界面的更新
        void showProgress();
        //若登录失败，则返回初始效果
        void reCovery();
    }

    interface Presenter extends BasePresenter<View> {
        //登录
        void login(final String username, String password);
        //加载进度条
        void progressAnimator(final android.view.View view);
        //当登录失败后，恢复默认界面状态
        void recovery(final android.view.View view);
    }
}
