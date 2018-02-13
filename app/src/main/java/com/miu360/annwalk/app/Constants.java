package com.miu360.annwalk.app;

import android.os.Environment;
import java.io.File;

/**
 * Created by Murphy on 2018/2/2.
 * 基础配置类
 */
public class Constants {
    //================= PATH ====================

    //private static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    //public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    public static final String PATH_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "codeest" + File.separator + "GeekNews";
    public static final String HEAD_URLNEW = "http://47.94.58.63/common/public";
}
