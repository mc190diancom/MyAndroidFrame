package com.miu360.annwalk.di.component;

import android.app.Activity;

import com.miu360.annwalk.di.module.FragmentModule;
import com.miu360.annwalk.di.scope.FragmentScope;
import com.miu360.annwalk.ui.fragment.HomeFragment;
import com.miu360.annwalk.ui.fragment.MineFragment;

import dagger.Component;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(HomeFragment homeFragment);

    void inject(MineFragment mineFragment);

}
