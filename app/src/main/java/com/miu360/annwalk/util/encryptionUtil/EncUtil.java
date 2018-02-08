package com.miu360.annwalk.util.encryptionUtil;

import android.util.Base64;
import android.util.Log;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by admin on 2017/11/21.
 */

public class EncUtil {

    private final static byte[] KEY = "chengdumiu360tec".getBytes();
    private final static byte[] IV = "chengdumiu360tec".getBytes();

    private static byte[] encryption(byte[] data) throws Exception {
        return cipherIV(Cipher.ENCRYPT_MODE, data);
    }

    private static byte[] decryption(byte[] data) throws Exception {
        return cipherIV(Cipher.DECRYPT_MODE, data);
    }

    private static byte[] cipherIV(int mode, byte[] data) throws Exception {
        SecretKeySpec sekey = new SecretKeySpec(KEY, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(mode, sekey, new IvParameterSpec(IV));
        byte[] decrypted = cipher.doFinal(data);
        return decrypted;
    }

    private static byte[] cipher(int mode, byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(mode, new SecretKeySpec(KEY, "AES"));
        byte[] decrypted = cipher.doFinal(data);
        return decrypted;
    }

    private static volatile EncUtil instance;

    private EncUtil() {

    }

    public static EncUtil getInstance() {
        if (instance == null) {
            synchronized (EncUtil.class) {
                if (instance == null) {
                    instance = new EncUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 加密
     *
     * @param value
     * @return
     */
    public String getEncode(String value) {
        try {
            byte[] encryption = encryption(value.getBytes());
            Log.e("paramList","paramList:"+encryption);
            return Base64.encodeToString(encryption, Base64.DEFAULT).replace("\n","");
        } catch (Exception e) {
            return value;
        }

    }

    /**
     * 解密
     *
     * @param value
     * @return
     */
    public String getDecode(String value) {
        try {
            byte[] decode = Base64.decode(value, Base64.DEFAULT);
            byte[] decryption = decryption(decode);
            return new String(decryption);
        } catch (Exception e) {
            return value;
        }
    }
}
