package com.miu360.annwalk.model.prefs;

import android.content.Context;

import com.miu360.annwalk.app.App;
import com.miu360.annwalk.app.Constants;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.util.XPreference;

import javax.inject.Inject;

/**
 * Created by Murphy on 2018/2/12.
 * sharedPreference的实现类
 */

public class ImplPreferencesHelper extends XPreference implements PreferencesHelper{
    private final static String SP_NAME = "user_info";

    @Inject
    public ImplPreferencesHelper() {
        super(SP_NAME, App.instance);
    }

    @Override
    public String getUserName() {
        return getString("name","空的");
    }

    @Override
    public String getUserBirth() {
        return getString("birth","空的");
    }

    @Override
    public void updateUser(User user) {
            setString("name", user.getName());
            setString("mobile", user.getMobile());
            setLong("yc_id", user.getId());
            setInt("checked", user.getChecked());
            setString("pop_code", user.getPop_code());
            setInt("haspwd", user.getHaspwd());
            setString("login_token", user.getLogin_token());
            setString("avar_url", Constants.HEAD_URLNEW+user.getHead());
            setString("birth", user.getBirth());
            setString("email", user.getEmail());
            setInt("gender", user.getSex());
    }
}
