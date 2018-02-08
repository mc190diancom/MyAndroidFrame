package com.miu360.annwalk.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Murphy on 2018/2/2.
 * 用于存放所有接口返回数据的errorCode和errormsg
 */

public class BaseEntity<E> {
    @SerializedName("error")
    private int error;
    @SerializedName("errormsg")
    private String errormsg;
    @SerializedName("data")
    private E data;

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

    public E getData() {
        return data;
    }

    public void setData(E data) {
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
