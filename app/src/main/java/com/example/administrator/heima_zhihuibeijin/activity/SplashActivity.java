package com.example.administrator.heima_zhihuibeijin.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.administrator.heima_zhihuibeijin.R;
import com.example.administrator.heima_zhihuibeijin.ulits.PrefUlits;

public class SplashActivity extends AppCompatActivity {

    private RelativeLayout rl;

    /**
     * 初始化闪屏页面的动画
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitys_splash);

        rl = (RelativeLayout) findViewById(R.id.rl_splash);

        //旋转动画效果
        RotateAnimation animRotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animRotate.setDuration(1000);
        animRotate.setFillAfter(true);
        //缩放动画效果
        ScaleAnimation animScale = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animScale.setDuration(1000);
        animScale.setFillAfter(true);
        //渐变动画效果
        AlphaAnimation animAlpha = new AlphaAnimation(0, 1);
        animScale.setDuration(2000);
        animScale.setFillAfter(true);

        AnimationSet set = new AnimationSet(true);
        set.addAnimation(animAlpha);
        set.addAnimation(animScale);
        set.addAnimation(animRotate);
        rl.startAnimation(set);

        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                boolean isFirstEnter = PrefUlits.getBoolean(getApplicationContext(), "IS_FIRST_ENTER", true);
                Intent intent;
                if (isFirstEnter) {
                    intent = new Intent(getApplicationContext(), GuideActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
