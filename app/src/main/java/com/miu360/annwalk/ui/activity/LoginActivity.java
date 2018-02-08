package com.miu360.annwalk.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miu360.annwalk.R;
import com.miu360.annwalk.base.BaseActivity;
import com.miu360.annwalk.base.contract.LoginContract;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View {
    private EditText username_et;
    private EditText password_et;

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
        username_et = (EditText) findViewById(R.id.username_et);
        password_et = (EditText) findViewById(R.id.password_et);
        Button login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                mPresenter.login(username_et.getText().toString(),password_et.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void LoginSuccess(User user) {
        Toast.makeText(LoginActivity.this,user.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFailed(String msg) {
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}
