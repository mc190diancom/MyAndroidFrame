package com.miu.enc;

import android.content.Context;
import android.util.Base64;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MiuEnc {

    public static byte[] iv = "0000000000000000".getBytes();

    static {
        System.loadLibrary("miu_enc");
    }

    public static native String getEK(Context ctx);

    public static native String getSK(Context ctx);

    public static String encodeAES(Context ctx, String msg) {
        try {
            byte[] textBytes = msg.getBytes("UTF-8");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            SecretKeySpec newKey = new SecretKeySpec(getEK(ctx).getBytes("UTF-8"), "AES");
            Cipher cipher = null;
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
            byte[] doFinal = cipher.doFinal(textBytes);
            return Base64.encodeToString(doFinal, Base64.DEFAULT);
//			return asHex(doFinal);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;

    }

    public static String decodeAES(Context ctx, String value) {
        try {
//            byte[] textBytes = asBin(value);
            byte[] textBytes = Base64.decode(value, Base64.DEFAULT);
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            SecretKeySpec newKey = new SecretKeySpec(getEK(ctx).getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
            return new String(cipher.doFinal(textBytes), "UTF-8");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)// 小于十前面补零
                strbuf.append("0");
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    private static byte[] asBin(String src) {
        if (src.length() < 1)
            return null;
        byte[] encrypted = new byte[src.length() / 2];
        for (int i = 0; i < src.length() / 2; i++) {
            int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);// 取高位字节
            int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);// 取低位字节
            encrypted[i] = (byte) (high * 16 + low);
        }
        return encrypted;
    }


    /**
     * DES加密
     */
    public static String encode(Context ctx, String msg) {
        try {
            byte[] textBytes = msg.getBytes("UTF-8");
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            DESKeySpec desKey = new DESKeySpec(getEK(ctx).getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            //用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, ivSpec);
            //现在，获取数据并加密
            //正式执行加密操作
            byte[] doFinal = cipher.doFinal(textBytes);
            return Base64.encodeToString(doFinal, Base64.DEFAULT).replace("\n", "");
//            return Base64.encodeToString(doFinal, Base64.DEFAULT);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * DES解密
     */
    public static String decode(Context ctx, String value) {
        try {
            byte[] textBytes = Base64.decode(value, Base64.DEFAULT);
            // DES算法要求有一个可信任的随机数源
            AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(getEK(ctx).getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, ivSpec);
            // 真正开始解密操作
            return new String(cipher.doFinal(textBytes), "UTF-8");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}