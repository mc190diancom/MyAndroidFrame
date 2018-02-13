package com.miu360.annwalk.model.data;

import android.content.Context;
import android.content.pm.PackageManager;

import com.miu360.annwalk.app.App;
import com.miu360.annwalk.util.encryptionUtil.EncUtil;
import com.miu360.annwalk.util.encryptionUtil.SignUtil;

import java.util.Map;

/**
 * Created by Murphy on 2018/2/12.
 * 公共数据配置
 */

class CommonData {
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

    static Map<String,String> Sign(Map<String, String> map, boolean isEncrypt){
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
}
