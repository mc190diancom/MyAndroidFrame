package com.miu360.annwalk.model.http;

import com.miu360.annwalk.base.BaseEntity;
import com.miu360.annwalk.model.bean.User;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by Murphy on 2018/2/2.
 * Http帮助类
 */

public interface HttpHelper {
    Flowable<BaseEntity<User>> getUserInfo(Map<String, String> params);
}
