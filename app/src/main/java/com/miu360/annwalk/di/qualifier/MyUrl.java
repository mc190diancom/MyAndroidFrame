package com.miu360.annwalk.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Murphy on 2018/2/6.
 * dagger2
 */

@Qualifier
@Documented
@Retention(RUNTIME)
public @interface MyUrl {

}
