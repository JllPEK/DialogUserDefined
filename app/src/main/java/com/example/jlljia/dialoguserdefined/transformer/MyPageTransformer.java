package com.example.jlljia.dialoguserdefined.transformer;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

/**
 * Created by jll.jia on 2017/5/16.
 */

public class MyPageTransformer implements ViewPager.PageTransformer {
    private static final float ROT_MAX = 20.0f;
    private float mRot;

    @Override
    public void transformPage(View page, float position) {
        //页面不可见
        if (position < -1) {
            Log.e("TAG [-Infinity,-1)  ", page + " , " + position + "");
            ViewCompat.setRotation(page, 0);

        }
        //页面可见：页面的左边界已划出屏幕
        else if (position < 0) {
            Log.e("TAG [-1, 0]", page + " , " + position + "");
            mRot = (ROT_MAX * position);
            Log.e("TAG [-1, 0]", page + " , mRot:" + mRot);
            ViewCompat.setPivotX(page, page.getMeasuredWidth());
            ViewCompat.setPivotY(page, page.getMeasuredHeight());
            ViewCompat.setRotation(page, mRot);
        //页面可见：页面的左边界已进入屏幕
        } else if (position < 1) {
            Log.e("TAG [0, 1]", page + " , " + position + "");
            mRot = (ROT_MAX * position);
            Log.e("TAG [0, 1]", page + " , mRot:" + mRot);
            ViewCompat.setPivotX(page, 0);
            ViewCompat.setPivotY(page, page.getMeasuredHeight());
            ViewCompat.setRotation(page, mRot);
        }
        //页面不可见
        else {
            Log.e("TAG (1,+Infinity] ", page + " , " + position + "");
            ViewCompat.setRotation(page, 0);
        }
    }
}
