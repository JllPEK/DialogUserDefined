package com.example.jlljia.dialoguserdefined.Layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.example.jlljia.dialoguserdefined.ICloseListener;

/**
 * 点击可取消View的布局
 * Created by jll.jia on 2017/5/17.
 */

public class ClickableLinearLayout extends LinearLayout {

    private GestureDetector mGestureDetector;
    private ICloseListener mIClose;

    public ClickableLinearLayout(Context context) {
        this(context, null);
    }

    public ClickableLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setOnCloseListener(ICloseListener listener) {
        this.mIClose = listener;
    }


    private void init() {
        mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent ev) {
                if (mIClose != null) {
                    mIClose.close();
                }
                return true;
            }
        });
        setClickable(true);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        mGestureDetector.onTouchEvent(ev);
        return super.onInterceptTouchEvent(ev);
    }

}
