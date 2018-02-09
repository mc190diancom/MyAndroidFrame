package com.miu360.annwalk.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.miu360.annwalk.R;

/**
 * Created by Murphy on 2018/2/9.
 * 用于展示各种图片
 */

public class imageLoderUtil {

    /**
     * 加载圆角图,暂时用到显示头像
     */
    public static void displayCircle(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .crossFade(500)
                .error(R.mipmap.ic_avatar_default)
                .transform(new GlideCircleTransform(imageView.getContext()))
                .into(imageView);
    }
}
