package com.miu360.annwalk.model.data;

import android.content.Context;
import android.content.pm.PackageManager;
import com.miu360.annwalk.app.App;
import com.miu360.annwalk.util.encryptionUtil.EncUtil;
import com.miu360.annwalk.util.encryptionUtil.SignUtil;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Murphy on 2018/2/6.
 * 请求数据时的一些公有参数
 */

public class UserData {
    private static final String APP_SOURCE = "1";

    private static int getVersion(Context ctx) {
        int versionCode = 0;
        try {
            versionCode = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    private static Map<String,String> Sign(Map<String,String> map,boolean isEncrypt){
        map.put("app_source",APP_SOURCE);
        map.put("app_version",getVersion(App.getInstance())+"");//getVersion(App.getInstance())+
        map.put("sign", SignUtil.sortSign(map));
        if(isEncrypt){//如果需要加密
            for (String key : map.keySet()) {
                if (!key.contains("sign") && !key.contains("timestamp")) {
                    String value = EncUtil.getInstance().getEncode(map.get(key));
                    map.put(key, value);
                }
            }
        }
        return map;
    }

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
        return Sign(map,true);
    }
}
