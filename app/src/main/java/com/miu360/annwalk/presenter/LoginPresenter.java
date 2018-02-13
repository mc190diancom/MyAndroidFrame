package com.miu360.annwalk.presenter;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.miu360.annwalk.base.BaseEntity;
import com.miu360.annwalk.base.RxPresenter;
import com.miu360.annwalk.base.contract.LoginContract;
import com.miu360.annwalk.model.DataManager;
import com.miu360.annwalk.model.bean.User;
import com.miu360.annwalk.model.data.UserData;
import com.miu360.annwalk.model.http.analysis.CommonSubscriber;
import com.miu360.annwalk.util.plugtor.JellyInterpolator;
import javax.inject.Inject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Murphy on 2018/2/1.
 * 登录的presenter
 */

public class LoginPresenter extends RxPresenter<LoginContract.View> implements LoginContract.Presenter{
    private DataManager mDataManager;

    @Inject
    LoginPresenter(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void attachView(LoginContract.View view) {
        super.attachView(view);
    }

    @Override
    public void login(final String username, String password) {
        mView.showProgress();
        addSubscribe(mDataManager.getUserInfo(UserData.login(username,password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CommonSubscriber<BaseEntity<User>>(mView) {
                    @Override
                    public void onNext(final BaseEntity<User> userBaseEntity) {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mView.reCovery();
                                if(userBaseEntity.isOk()){
                                    mView.LoginSuccess(userBaseEntity.getData());
                                    mDataManager.updateUser(userBaseEntity.getData());
                                }else{
                                    mView.LoginFailed(userBaseEntity.getErrormsg());
                                }
                            }
                        },1000);

                    }
                }
                ));
    }

    @Override
    public void progressAnimator(final View view) {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
                0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
                0.5f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view,
                animator, animator2);
        animator3.setDuration(1000);
        animator3.setInterpolator(new JellyInterpolator());
        animator3.start();
    }

    @Override
    public void recovery(final View view) {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        view.setLayoutParams(params);

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX", 0.5f,1f );
        animator2.setDuration(500);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());
        animator2.start();
    }

}
