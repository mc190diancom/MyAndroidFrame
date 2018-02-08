package com.miu360.annwalk.model.http.analysis;

import android.text.TextUtils;

import com.miu360.annwalk.base.contract.BaseView;
import org.apache.http.conn.ConnectTimeoutException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * Created by Murphy on 2018/2/5.
 * 重写ResourceSubscriber，用于处理一些公共返回信息，管理线程等
 */

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState = true;

    protected CommonSubscriber(BaseView view){
        this.mView = view;
    }

    protected CommonSubscriber(BaseView view, String errorMsg){
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState){
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState){
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable t) {
        if (mView == null) {
            return;
        }
        String clsName = t.getClass().getName();
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        }else if (t instanceof SocketTimeoutException) {
            mView.showErrorMsg("服务器网络超时，请稍后重试");
        } else if (t instanceof ConnectTimeoutException) {
            mView.showErrorMsg("请求服务器超时，请检查网络");
        } else if (t instanceof ConnectException) {
            mView.showErrorMsg("请求服务器失败，请检查网络");
        } else if (t.getClass().getName().toLowerCase().contains("timeout")) {
            if (t.getMessage() != null && t.getMessage().contains("read")) {
                mView.showErrorMsg("服务器网络超时，请稍后重试");
            } else {
                mView.showErrorMsg("请求服务器超时，请检查网络");
            }
        } else if (t instanceof HttpException) {
            mView.showErrorMsg("网络不稳定，请稍后再试");
        } else if (clsName.startsWith("java.net") || clsName.startsWith("org.apache.http")
                || t instanceof EOFException) {
            mView.showErrorMsg("网络不稳定，请稍后再试");
        } else if(t instanceof FileNotFoundException &&t.getMessage().contains("http://")){
            mView.showErrorMsg("请求服务器报错");
        } else{
            mView.showErrorMsg("未知错误" + "\r\n" + t.getMessage());
        }
        if (isShowErrorState) {
            mView.stateError();
        }
    }
}
