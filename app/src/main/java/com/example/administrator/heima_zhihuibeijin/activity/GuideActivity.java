package com.example.administrator.heima_zhihuibeijin.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;

import com.example.administrator.heima_zhihuibeijin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/15.
 */
public class GuideActivity extends Activity {

    private ViewPager vp_guide;
    private Button bt_enter;
    private int[] mImageId = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};
    private List<ImageView> imageViewList = new ArrayList<>();

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
        }
        MyAdapter adapter = new MyAdapter();
        vp_guide.setAdapter(adapter);
    }

    private void initUi() {
        vp_guide = (ViewPager) findViewById(R.id.vp_guide);
        bt_enter = (Button) findViewById(R.id.bt_enter);
    }

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
