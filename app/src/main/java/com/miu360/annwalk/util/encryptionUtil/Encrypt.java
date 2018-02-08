package com.miu360.annwalk.util.encryptionUtil;

/**
 * Created by Administrator on 2017/3/13.
 */
public class Encrypt {
    /*把加密的字符串替换某些字符*/
    public static String replace(String s) {
        return s.replace("+", "-").replace("/", "_").replace("=", "");
    }

    /*把字符向右移位*/
    public static String moveRight(String s) {
        char[] cc = s.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            char c = cc[i];
            if (48 <= c && c <= 57) {
                c++;
                if (c == 58) {
                    c = 48;
                }
            } else if (65 <= c && c <= 90) {
                c++;
                if (c == 91) {
                    c = 65;
                }
            } else if (97 <= c && c <= 122) {
                c++;
                if (c == 123) {
                    c = 97;
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

    /*转换成数组，并首尾调换*/
    public static char[] reverse(String s) {
        char[] c = s.toCharArray(), cc = new char[s.length()];
        for (int i = c.length - 1, j = 0; i >= 0; i--, j++) {
            cc[j] = c[i];
        }
        return cc;
    }

    /*加上盐值*/
    public static String add(String key, char[] cc) {
        char[] c = key.toCharArray();
        String[] str = new String[cc.length];
        for (int i = 0; i < str.length; i++) {
            if (i < c.length) {
                str[i] = String.valueOf(cc[i]) + String.valueOf(c[i]);
            } else {
                str[i] = String.valueOf(cc[i]);
            }

        }
        String sss = "";
        for (int i = 0; i < str.length; i++) {
            sss += str[i];
        }
        return sss;
    }


}
