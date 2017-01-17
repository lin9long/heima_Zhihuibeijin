package com.example.administrator.heima_zhihuibeijin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.administrator.heima_zhihuibeijin.R;
import com.example.administrator.heima_zhihuibeijin.utils.ConstantsValue;
import com.example.administrator.heima_zhihuibeijin.utils.PrefUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class GuideActivity extends Activity {

    private ViewPager vp_guide;
    private LinearLayout ll_container;
    private Button bt_enter;
    private int[] mImageId = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private List<ImageView> imageViewList = new ArrayList<>();
    private ImageView iv_red_point;
    private int mPointDis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initUi();
        initDate();
    }


    private void initDate() {
        for (int i = 0; i < mImageId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(mImageId[i]);
            imageViewList.add(imageView);
            //获取小圆点，初始化布局
            ImageView point = new ImageView(this);
            point.setImageResource(R.drawable.shape_narmal_point);
            //设置layout的背景参数
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //当小圆点不为第一个点的时候，左边距加上10个dp宽度
            if (i > 0) {
                params.leftMargin = 15;
            }
            //设置参数属性
            point.setLayoutParams(params);
            ll_container.addView(point);
        }
        MyAdapter adapter = new MyAdapter();
        vp_guide.setAdapter(adapter);

        vp_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /** 页面滚动调用的方法
             * @param position 当前页面位置
             * @param positionOffset 偏移量百分比
             * @param positionOffsetPixels 偏移像素大小
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //将onPageScrollStateChanged方法内获取的两点距离，乘以偏移量百分比，与距离相加，得出最后的
                int disLeftMargin = (int) (mPointDis * positionOffset) + position * mPointDis;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) iv_red_point.getLayoutParams();
                params.leftMargin = disLeftMargin;
                iv_red_point.setLayoutParams(params);

            }

            //当前被选中页面
            @Override
            public void onPageSelected(int position) {

                //不能写死position的位置，因为splash可能会有多个页面
                if (position > mImageId.length - 2) {
                    bt_enter.setVisibility(View.VISIBLE);
                }
            }

            //当前页面状态发生改变
            @Override
            public void onPageScrollStateChanged(int state) {
                //因为在OnCreate方法内部无法直接调用OnLayout的方法，需要声明一个监听者
                iv_red_point.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        //取消LayoutListener的注册，否则系统会调用多次
                        iv_red_point.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        mPointDis = ll_container.getChildAt(1).getLeft() - ll_container.getChildAt(0).getLeft();
                        System.out.println(mPointDis);
                    }
                });
            }
        });
    }

    private void initUi() {
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        bt_enter = (Button) findViewById(R.id.bt_enter);
        ll_container = (LinearLayout) findViewById(R.id.ll_container);
        iv_red_point = (ImageView) findViewById(R.id.iv_red_point);
        bt_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrefUtils.putBoolean(getApplicationContext(), ConstantsValue.IS_FIRST_ENTER,false);
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    //初始化PagerAdapter数据
    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView view = imageViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
