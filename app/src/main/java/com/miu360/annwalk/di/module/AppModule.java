package com.miu360.annwalk.di.module;

import com.miu360.annwalk.app.App;
import com.miu360.annwalk.model.DataManager;
import com.miu360.annwalk.model.http.HttpHelper;
import com.miu360.annwalk.model.http.RetrofitHelper;
import com.miu360.annwalk.model.prefs.ImplPreferencesHelper;
import com.miu360.annwalk.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by codeest on 16/8/7.
 * dagger2
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper,PreferencesHelper preferencesHelper) {
        return new DataManager(httpHelper,preferencesHelper);
    }
}
