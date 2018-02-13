package com.miu360.annwalk.di.component;

import com.miu360.annwalk.app.App;
import com.miu360.annwalk.di.module.AppModule;
import com.miu360.annwalk.di.module.HttpModule;
import com.miu360.annwalk.model.DataManager;
import com.miu360.annwalk.model.http.RetrofitHelper;
import com.miu360.annwalk.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper retrofitHelper();  //提供http的帮助类

    //RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}
