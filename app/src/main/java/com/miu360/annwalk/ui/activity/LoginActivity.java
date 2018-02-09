package com.miu360.annwalk.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.miu360.annwalk.R;
import com.miu360.annwalk.base.BaseActivity;
import com.miu360.annwalk.base.contract.LoginContract;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.presenter.LoginPresenter;
import com.miu360.annwalk.util.SystemUtil;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View {
    private EditText username_et;
    private EditText password_et;
    private View mInputLayout;
    private View progress;
    private LinearLayout mName, mPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    private void initView() {
        username_et = (EditText) findViewById(R.id.log_id);
        password_et = (EditText) findViewById(R.id.log_pwd);
        Button login_btn = (Button) findViewById(R.id.log_login);
        progress = findViewById(R.id.layout_progress);
        mInputLayout = findViewById(R.id.input_layout);
        mName = (LinearLayout) findViewById(R.id.ll1);
        mPsw = (LinearLayout) findViewById(R.id.ll2);

        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.log_login:
                startLogin();
                break;
            default:
                break;
        }
    }

    /**
     * 登录执行的操作
     */
    private void startLogin() {
        mName.setVisibility(View.INVISIBLE);
        mPsw.setVisibility(View.INVISIBLE);
        mPresenter.login(username_et.getText().toString(),password_et.getText().toString());
    }

    @Override
    public void LoginSuccess(User user) {
        SystemUtil.toast(self,user.toString(),Toast.LENGTH_SHORT);
    }

    @Override
    public void LoginFailed(String msg) {
        mPresenter.recovery(mInputLayout);
        SystemUtil.toast(self,msg,Toast.LENGTH_SHORT);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        mPresenter.progressAnimator(progress);
        mInputLayout.setVisibility(View.GONE);
    }

    @Override
    public void reCovery() {
        progress.setVisibility(View.GONE);
        mInputLayout.setVisibility(View.VISIBLE);
        mName.setVisibility(View.VISIBLE);
        mPsw.setVisibility(View.VISIBLE);
    }
}
