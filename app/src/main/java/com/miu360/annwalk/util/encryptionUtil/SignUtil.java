package com.miu360.annwalk.util.encryptionUtil;

import com.miu.enc.MiuEnc;
import com.miu360.annwalk.app.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Created by yd on 2017/7/27.
 */

public class SignUtil {
    /**
     * 按照参数名排序并加密
     */
    public static String sortSign(Map<String,String> map) {
        map.put("sign_key", "8iu*d7&i327^&%&)");//MiuEnc.getSK(App.getInstance()) 8iu*d7&i327^&%&)
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            buf.append(list.get(i).getKey())
                    .append("=")
                    .append(list.get(i).getValue());
            if (i < list.size() - 1)
                buf.append("&");
        }
        map.remove("sign_key");
        return MD5Utils.md5(buf.toString());
    }

}
