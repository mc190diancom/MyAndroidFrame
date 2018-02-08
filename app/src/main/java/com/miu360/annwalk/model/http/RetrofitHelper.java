package com.miu360.annwalk.model.http;

import com.miu360.annwalk.base.BaseEntity;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.model.http.api.MyApis;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by Murphy on 2018/2/7.
 * Retrofit帮助类
 */

public class RetrofitHelper implements HttpHelper{

    private MyApis mMyApiService;

    @Inject
    RetrofitHelper(MyApis myApiService){
        this.mMyApiService = myApiService;
    }

    @Override
    public Flowable<BaseEntity<User>> getUserInfo(Map<String, String> params) {
        return mMyApiService.getData(params);
    }
}
