package com.app.mvvm_jetpack.ui.activity.home;

import android.os.Bundle;

import com.app.baselib.base.BaseActivity;
import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.ui.fragment.home.ImageNewsFragment;
import com.app.mvvm_jetpack.ui.fragment.home.ListInfoNewsFragment;
import com.app.mvvm_jetpack.ui.fragment.home.MyInfoFragment;
import com.app.mvvm_jetpack.utils.BottomNavigationViewHelper;
import com.app.mvvm_jetpack.utils.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends BaseActivity {

    private BottomNavigationView bv;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bv = findViewById(R.id.home_nav);
        viewPager = findViewById(R.id.viewpager);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationViewHelper.disableShiftMode(bv);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ImageNewsFragment());
        viewPagerAdapter.addFragment(new ListInfoNewsFragment());
        viewPagerAdapter.addFragment(new MyInfoFragment());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        bv.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.menu_info:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.menu_my:
                    viewPager.setCurrentItem(2);
                    break;
            }
            return false;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                bv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}