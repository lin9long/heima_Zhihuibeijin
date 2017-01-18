package com.example.administrator.heima_zhihuibeijin.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.heima_zhihuibeijin.R;
import com.example.administrator.heima_zhihuibeijin.activity.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 5个标签页的基类
 * Created by Administrator on 2017/1/17.
 */

public class BasePager {
    public final View mRootView;
    public Activity mActivity;
    public FrameLayout flContent;
    public ImageButton ibMenu;
    public TextView tvTitle;


    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    public View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        //空的帧布局，需要动态往里面添加内容
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        ibMenu = (ImageButton) view.findViewById(R.id.ib_menu);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        ibMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        return view;

    }

    private void toggle() {
        MainActivity mainUi = (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainUi.getSlidingMenu();
        slidingMenu.toggle();
    }

    public void initData() {

    }
}
