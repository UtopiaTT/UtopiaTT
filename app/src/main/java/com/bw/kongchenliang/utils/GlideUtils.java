package com.bw.kongchenliang.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtils {
    private volatile static GlideUtils glideUtils;

    public static GlideUtils getInstance() {
        if (glideUtils==null){
            synchronized (GlideUtils.class){
                if (glideUtils==null){
                    glideUtils=new GlideUtils();
                }
            }
        }
        return glideUtils;
    }
    public void imgGlide(Context context, String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);
    }
}
