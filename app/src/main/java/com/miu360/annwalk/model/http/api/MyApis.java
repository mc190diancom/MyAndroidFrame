package com.miu360.annwalk.model.http.api;

import com.miu360.annwalk.base.BaseEntity;
import com.miu360.annwalk.model.bean.User;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Murphy on 2018/2/2.
 * 存放所有自己的接口
 */

public interface MyApis {
    String SERVER_URLNEW = "http://47.94.58.63/auth/public/index.php/index/";//新接口用户管理
    /**
     *  登录接口
     *@return List<>
     */
    //参数较多
    @FormUrlEncoded
    @POST("Yc/passenger2login")
    Flowable<BaseEntity<User>> getData(@FieldMap Map<String, String> params);
}
