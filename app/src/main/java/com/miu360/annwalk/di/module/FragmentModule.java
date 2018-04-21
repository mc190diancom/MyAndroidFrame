package com.miu360.annwalk.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;


import com.miu360.annwalk.di.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
