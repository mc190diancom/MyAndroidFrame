package com.miu360.annwalk.base;

/**
 * Created by Murphy on 2018/2/2.
 * 用于存放所有接口返回数据的errorCode和errormsg
 */

public class BaseEntity<T> {
    private int error;
    private String errormsg;
    private T data;

    public boolean isOk() {
        return error == 0;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "error=" + error +
                ", errormsg='" + errormsg + '\'' +
                ", data=" + data +
                '}';
    }
}
