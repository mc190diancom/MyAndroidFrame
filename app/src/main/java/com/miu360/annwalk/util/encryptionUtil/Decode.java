package com.miu360.annwalk.util.encryptionUtil;

/**
 * Created by Administrator on 2017/3/13.
 */
public class Decode {
    public static char[] get(String key, String content) {
        char[] c = key.toCharArray(), cc = content.toCharArray();
        StringBuffer sb = new StringBuffer();
        if (content.length() % 2 == 0) {
            // 当content的长度为偶数时，需要key和ccc的长度满足一些情况才会出现
            // 1.key的长度>=ccc的长度时
            if (c.length >= cc.length / 2) {
                for (int i = 0; i < cc.length; i++) {
                    if (i % 2 == 0) {
                        sb.append(String.valueOf(cc[i]));
                    }
                }
            } else {// 2.key的长度<ccc的长度时并且两个要么同为奇数要么同为偶数
                for (int i = 0; i < cc.length; i++) {
                    if (i / 2 < c.length) {
                        if (i % 2 == 0) {
                            sb.append(String.valueOf(cc[i]));
                        }
                    } else {
                        sb.append(String.valueOf(cc[i]));
                    }
                }
            }
        } else {
            // 当content的长度为奇数时，key和ccc的长度其中一个必须有一个为奇数，一个为偶数
            // 这个时候key的长度肯定<ccc的长度,并且key的两倍长度里面0开始的下标奇数位对应的肯定为key的内容
            for (int i = 0; i < cc.length; i++) {
                if (i / 2 < c.length) {
                    if (i % 2 == 0) {
                        sb.append(String.valueOf(cc[i]));
                    }
                } else {
                    sb.append(String.valueOf(cc[i]));
                }
            }

        }
        return sb.toString().toCharArray();
    }

    public static String reverse(char[] c) {
        String s = "";
        for (int i = c.length - 1; i >= 0; i--) {
            s += c[i];
        }
        return s;
    }

    public static String moveLeft(String s) {
        char[] cc = s.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            char c = cc[i];
            if (48 <= c && c <= 57) {
                c--;
                if (c == 47) {
                    c = 57;
                }
            } else if (65 <= c && c <= 90) {
                c--;
                if (c == 64) {
                    c = 90;
                }
            } else if (97 <= c && c <= 122) {
                c--;
                if (c == 96) {
                    c = 122;
                }
            } else if (c == 45) {
                c = 95;
            } else if (c == 95) {
                c = 45;
            }
            cc[i] = c;
        }
        return String.valueOf(cc);
    }

    public static String replace2(String s) {
        /*String ss = s.replace("-", "+").replace("_", "/");
        int x = ss.length()%4;
        for(int i){

        }*/
        return s.replace("-", "+").replace("_", "/");
    }

    public static String addEqual(String s) {
        int i = s.length() % 4;
        for (int j = 0; j < i; j++) {
            s += "=";
        }
        return s;
    }


}
