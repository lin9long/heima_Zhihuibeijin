package com.example.administrator.heima_zhihuibeijin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.heima_zhihuibeijin.R;
import com.example.administrator.heima_zhihuibeijin.fragment.ContentFragment;
import com.example.administrator.heima_zhihuibeijin.fragment.LeftMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by Administrator on 2017/1/15.
 */
public class MainActivity extends SlidingFragmentActivity {
    private static final String ADD_CONTENT = "add_content";
    private static final String ADD_LEFT_MENU = "add_left_menu";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加侧边栏到布局内
        setBehindContentView(R.layout.sliding_leftmenu);
        //获取侧边栏的对象，调用内部的方法
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setBehindOffset(450);
        initFragment();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_content, new ContentFragment(), ADD_CONTENT);
        transaction.add(R.id.fl_left_menu, new LeftMenuFragment(), ADD_LEFT_MENU);
        transaction.commit();
    }

    //给子方法获取左边栏fragment
    public LeftMenuFragment getLeftFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        LeftMenuFragment leftMenuFragment = (LeftMenuFragment) fragmentManager.findFragmentByTag(ADD_LEFT_MENU);
        return leftMenuFragment;
    }
    //给子方法获取主内容fragment
    public ContentFragment getContentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ContentFragment contentFragment = (ContentFragment) fragmentManager.findFragmentByTag(ADD_CONTENT);
        return contentFragment;
    }
}
