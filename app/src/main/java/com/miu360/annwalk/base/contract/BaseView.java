package com.miu360.annwalk.base.contract;

/**
 * Created by Murphy on 2018/2/1.
 * View基类
 */

public interface BaseView {

    void showErrorMsg(String msg);//错误信息获取

    void useNightMode(boolean isNight);//是否夜间模式
    //=======  State  =======
    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
