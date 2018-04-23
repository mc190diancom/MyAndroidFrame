package com.miu360.annwalk.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.widget.Toast;

import com.miu360.annwalk.R;
import com.miu360.annwalk.base.BaseActivity;
import com.miu360.annwalk.base.contract.LoginContract;
import com.miu360.annwalk.databinding.ActivityLoginBinding;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.presenter.LoginPresenter;
import com.miu360.annwalk.util.SystemUtil;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {
    private ActivityLoginBinding mBinding;

    @Override
    protected void getLayout() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mBinding.logLogin.setOnClickListener(this);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.log_login:
               // mBinding.inputLayout.ll1.setVisibility(View.INVISIBLE);
               // mBinding.inputLayout.ll2.setVisibility(View.INVISIBLE);
                mPresenter.login(mBinding.inputLayout.logId.getText().toString(),mBinding.inputLayout.logPwd.getText().toString());
                break;
        }
    }

    @Override
    public void LoginSuccess(User user) {
        startActivity(new Intent(mContext,MainActivity.class));
    }

    @Override
    public void LoginFailed(String msg) {
        mPresenter.recovery(mBinding.inputLayout.inputLayout);
        SystemUtil.toast(mContext,msg,Toast.LENGTH_SHORT);
    }

    @Override
    public void showProgress() {
        mBinding.layoutProgress.layoutProgress.setVisibility(View.VISIBLE);
        mPresenter.progressAnimator(mBinding.layoutProgress.layoutProgress);
        mBinding.inputLayout.inputLayout.setVisibility(View.GONE);
    }

    @Override
    public void reCovery() {
        mBinding.layoutProgress.layoutProgress.setVisibility(View.GONE);
        mBinding.inputLayout.inputLayout.setVisibility(View.VISIBLE);
        mBinding.inputLayout.ll1.setVisibility(View.VISIBLE);
        mBinding.inputLayout.ll2.setVisibility(View.VISIBLE);
    }

}
