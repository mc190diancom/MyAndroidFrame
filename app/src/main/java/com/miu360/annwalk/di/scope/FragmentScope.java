package com.miu360.annwalk.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
