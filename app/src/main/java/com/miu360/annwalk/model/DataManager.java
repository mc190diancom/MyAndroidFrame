package com.miu360.annwalk.model;

import com.miu360.annwalk.base.BaseEntity;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.model.http.HttpHelper;
import com.miu360.annwalk.model.prefs.PreferencesHelper;

import java.util.Map;
import io.reactivex.Flowable;

/**
 * Created by Murphy on 2018/2/2.
 *
 */

public class DataManager implements HttpHelper,PreferencesHelper {
    private HttpHelper mHttpHelper;
    private PreferencesHelper mPreferencesHelper;

    public DataManager(HttpHelper httpHelper,PreferencesHelper preferencesHelper){
        mHttpHelper = httpHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Flowable<BaseEntity<User>> getUserInfo(Map<String, String> params) {
        return mHttpHelper.getUserInfo(params);
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public String getUserBirth() {
        return mPreferencesHelper.getUserBirth();
    }

    @Override
    public void updateUser(User user) {
        mPreferencesHelper.updateUser(user);
    }
}
