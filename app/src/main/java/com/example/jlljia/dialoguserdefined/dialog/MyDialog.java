package com.example.jlljia.dialoguserdefined.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jlljia.dialoguserdefined.R;
import com.example.jlljia.dialoguserdefined.adapter.NoticeAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jll.jia on 2017/5/15.
 */

public class MyDialog extends Dialog {

    private ViewPager mViewPager;

    public MyDialog(@NonNull Context context) {
        //设置自定义Dialog的主题风格
        super(context, R.style.selfDefDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置Dialog的显示方式：alpha :0->1
        getWindow().setWindowAnimations(R.style.popupAnimation);
        //设置Dialog布局
        setContentView(R.layout.dialog_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(createAdapter());
    }

    private PagerAdapter createAdapter() {
        List<View> adapterViews = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.adapter_view_layout, null);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_adapter_title);
            tvTitle.setText("我是第" + (i + 1) + "页");
            adapterViews.add(view);
        }

        return new NoticeAdapter(adapterViews);

    }
}
