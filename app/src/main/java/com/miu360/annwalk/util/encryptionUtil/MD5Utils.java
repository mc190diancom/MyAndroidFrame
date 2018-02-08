package com.miu360.annwalk.util.encryptionUtil;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Murphy on 2018/2/2.
 */

public class MD5Utils {
    public static String md5(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] e = md.digest(value.getBytes());
            return toHex(e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return value;
        }
    }

    public static String md5(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] e = md.digest(bytes);
            return toHex(e);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String toHex(byte bytes[]) {
        StringBuilder hs = new StringBuilder();
        String stmp = "";
        for (int n = 0; n < bytes.length; n++) {
            stmp = Integer.toHexString(bytes[n] & 0xff);
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }
        return hs.toString();
    }
    private static final char HEX_DIGITS[] = {'0','1','2','3','4',
            '5','6','7','8','9','a','b','c','d','e','f'};

    // check md5 message
    public static boolean checkMD5(String mMD5Msg, String mPathFile){
        if(TextUtils.isEmpty(mMD5Msg)){
            Log.d("MD5", "md5 is null,ignore ");
            return false;
        }
        String msg = createMD5(mPathFile);

        if((msg != null) && (mMD5Msg.equalsIgnoreCase(msg))){
            return true;
        }
        return false;
    }

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    // create md5 message from the /mnt/sdcard/update.zip(mPathFile)
    public static String createMD5(String mPathFile){
        File mFile = new File(mPathFile);
        FileInputStream fis;
        byte[] buffer = new byte[1024];
        int numRead = 0;
        MessageDigest md5;

        try {
            fis = new FileInputStream(mFile);
            md5 = MessageDigest.getInstance("MD5");
            while((numRead=fis.read(buffer)) > 0) {
                md5.update(buffer,0,numRead);
            }
            fis.close();
            return toHexString(md5.digest());
        } catch (IOException e) {
            System.out.println("check md5 fail");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("check md5 fail");
            e.printStackTrace();
        }
        return null;
    }
}
