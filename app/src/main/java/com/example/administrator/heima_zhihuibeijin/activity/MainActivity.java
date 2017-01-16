package com.example.administrator.heima_zhihuibeijin.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.heima_zhihuibeijin.R;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * Created by Administrator on 2017/1/15.
 */
public class MainActivity extends SlidingFragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.sliding_leftmenu);
    }
}
