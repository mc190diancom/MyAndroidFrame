package com.miu360.annwalk.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.miu360.annwalk.app.App;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Murphy on 2018/2/2.
 * 无MVP的activity基类
 */

public abstract class SimpleActivity extends SupportActivity {

    protected Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        onViewCreated();
        App.getInstance().addActivity(this);
        initEventAndData();
    }

    protected void onViewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().removeActivity(this);
    }

    protected abstract int getLayout();
    protected abstract void initEventAndData();
}
