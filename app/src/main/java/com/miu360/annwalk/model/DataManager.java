package com.miu360.annwalk.model;

import com.miu360.annwalk.base.BaseEntity;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.model.http.HttpHelper;
import java.util.Map;
import io.reactivex.Flowable;

/**
 * Created by Murphy on 2018/2/2.
 *
 */

public class DataManager implements HttpHelper {
    private HttpHelper mHttpHelper;

    public DataManager(HttpHelper httpHelper){
        mHttpHelper = httpHelper;
    }

    @Override
    public Flowable<BaseEntity<User>> getUserInfo(Map<String, String> params) {
        return mHttpHelper.getUserInfo(params);
    }
}
