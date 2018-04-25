package com.miu360.annwalk.base;

/**
 * Created by Murphy on 2018/2/1.
 * Presenter基类
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
