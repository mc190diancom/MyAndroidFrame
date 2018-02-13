package com.miu360.annwalk.model.prefs;

import com.miu360.annwalk.model.bean.User;

/**
 * Created by Murphy on 2018/2/2.
 * SharedPreferences帮助类
 */

public interface PreferencesHelper {
    String getUserName();
    String getUserBirth();
    void updateUser(User user);
}
