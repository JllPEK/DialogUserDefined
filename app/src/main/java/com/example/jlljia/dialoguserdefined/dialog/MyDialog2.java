package com.example.jlljia.dialoguserdefined.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.jlljia.dialoguserdefined.ICloseListener;
import com.example.jlljia.dialoguserdefined.Layout.ClickableLinearLayout;
import com.example.jlljia.dialoguserdefined.R;
import com.example.jlljia.dialoguserdefined.adapter.NoticeAdapter;
import com.example.jlljia.dialoguserdefined.transformer.MyPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jll.jia on 2017/5/16.
 */

public class MyDialog2 extends Dialog {

    private ViewPager mViewPager;
    private ClickableLinearLayout llContent;

    public MyDialog2(@NonNull Context context) {
        //设置自定义Dialog的主题风格
        super(context, R.style.selfDefDialog2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置Dialog的显示方式：alpha :0->1
        getWindow().setWindowAnimations(R.style.popupAnimation);
        //设置Dialog布局
        setContentView(R.layout.dialog_layout2);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        llContent = (ClickableLinearLayout) findViewById(R.id.ll_content);
        mViewPager.setAdapter(createAdapter());
        mViewPager.setPageTransformer(true, new MyPageTransformer());
        llContent.setOnCloseListener(new ICloseListener() {
            @Override
            public void close() {
                dismiss();
            }
        });
    }

    private PagerAdapter createAdapter() {
        List<View> adapterViews = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_view_layout2, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_adapter_title);
            tvTitle.setText("我是第" + (i + 1) + "页(2)");
            adapterViews.add(view);
        }

        return new NoticeAdapter(adapterViews);

    }
}
