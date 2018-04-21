package com.miu360.annwalk.model.http.exception;

/**
 * Created by Murphy on 2018/4/20.
 * 对于接口返回的错误数据，这里统一处理
 */

public class ApiException extends Exception{
    private int error;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, int error) {
        super(msg);
        this.error = error;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
