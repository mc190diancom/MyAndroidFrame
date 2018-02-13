package com.miu360.annwalk.model.data;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Murphy on 2018/2/6.
 * 请求数据时的一些公有参数
 */

public class UserData {
    /**
     * 密码登录
     */
    public static Map<String,String> login(String mobile, String pwd) {
        long timestamp = Calendar.getInstance().getTimeInMillis();
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("pwd",pwd);
        map.put("device_id","cd0cdd20faaec66f1937cd75179c17e1");//cd0cdd20faaec66f1937cd75179c17e1 getToken(App.getInstance())
        map.put("timestamp",String.valueOf(timestamp));
        return CommonData.Sign(map,true);
    }
}
