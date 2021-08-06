package com.app.mvvm_jetpack.ui.activity.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.base.BaseActivity;
import com.app.mvvm_jetpack.databinding.ActivityHomeBinding;
import com.app.mvvm_jetpack.ui.fragment.images.ImageNewsFragment;
import com.app.mvvm_jetpack.ui.fragment.news.headlinenews.NewsFragment;
import com.app.mvvm_jetpack.ui.fragment.my.MyInfoFragment;
import com.app.mvvm_jetpack.view.DataGenerator;
import com.app.mvvm_jetpack.view.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    private TabLayout mTabLayout;
    private ViewPager viewPager;
    private List<Fragment> mFragmensts;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView(ActivityHomeBinding bindView) {
        mFragmensts = new ArrayList<>();
        mFragmensts.add(new NewsFragment());
        mFragmensts.add(new ImageNewsFragment());
        mFragmensts.add(new MyInfoFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmensts);
        mTabLayout = bindView.tabLayout;
        viewPager = bindView.viewpager;
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(mFragmensts.size() -1);
        viewPager.setCurrentItem(0, false);
        for (int i = 0; i < mFragmensts.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(DataGenerator.getTabView(this, i)));
        }
        DataGenerator.chooseFirst(this,mTabLayout);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),true);
                DataGenerator.recoverItem(mFragmensts.size(),HomeActivity.this,mTabLayout);
                View view =tab.getCustomView();
                ImageView imageView = view.findViewById(R.id.tab_content_image);
                TextView textView = view.findViewById(R.id.tab_content_text);
                imageView.setImageDrawable(getResources().getDrawable(DataGenerator.mTabResPressed[tab.getPosition()]));
                textView.setTextColor(getResources().getColor(R.color.color_focused));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

}