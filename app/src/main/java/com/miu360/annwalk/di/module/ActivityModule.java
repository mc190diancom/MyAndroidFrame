package com.miu360.annwalk.di.module;

import android.app.Activity;

import com.miu360.annwalk.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
