package com.miu360.annwalk.di.component;

import android.app.Activity;
import com.miu360.annwalk.di.module.ActivityModule;
import com.miu360.annwalk.di.scope.ActivityScope;
import com.miu360.annwalk.ui.activity.LoginActivity;
import com.miu360.annwalk.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(LoginActivity loginActivity);

    void inject(MainActivity mainActivity);

}
