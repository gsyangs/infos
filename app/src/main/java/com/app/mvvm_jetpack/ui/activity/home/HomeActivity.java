package com.app.mvvm_jetpack.ui.activity.home;

import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.base.BaseActivity;
import com.app.mvvm_jetpack.databinding.ActivityHomeBinding;
import com.app.mvvm_jetpack.ui.fragment.images.ImageNewsFragment;
import com.app.mvvm_jetpack.ui.fragment.news.ListInfoNewsFragment;
import com.app.mvvm_jetpack.ui.fragment.my.MyInfoFragment;
import com.app.mvvm_jetpack.view.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

import androidx.viewpager.widget.ViewPager;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> {

    private BottomNavigationView bv;
    private ViewPager viewPager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initView(ActivityHomeBinding bindView) {

        bv = bindView.homeNav;
        bv.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        viewPager = bindView.viewpager;
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