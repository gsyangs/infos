package com.app.mvvm_jetpack.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.mvvm_jetpack.R;
import com.app.mvvm_jetpack.ui.fragment.images.ImageNewsFragment;
import com.app.mvvm_jetpack.ui.fragment.my.MyInfoFragment;
import com.app.mvvm_jetpack.ui.fragment.news.headlinenews.NewsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

/**
 * @author:create by ys
 * 时间:2021/7/12 17
 * 邮箱 894417048@qq.com
 */
public class DataGenerator {

    public static final int []mTabRes = new int[]{R.mipmap.home,R.mipmap.info,R.mipmap.my};
    public static final int []mTabResPressed = new int[]{R.mipmap.home_selected,R.mipmap.info_selected,R.mipmap.my_selected};
    public static final String []mTabTitle = new String[]{"新闻","美图","我的"};

    public static List<Fragment> getFragments(String from){
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(NewsFragment.newInstance(from));
        fragments.add(ImageNewsFragment.newInstance(from));
        fragments.add(MyInfoFragment.newInstance(from));
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content,null);
        ImageView tabIcon = view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }


    public static void recoverItem(int size,Context context,TabLayout tabLayout) {
        for (int i = 0; i < size; i++) {
            TabLayout.Tab tabAt =  tabLayout.getTabAt(i);
            View view = tabAt.getCustomView();
            ImageView imageView = view.findViewById(R.id.tab_content_image);
            TextView textView = view.findViewById(R.id.tab_content_text);
            imageView.setImageDrawable(context.getResources().getDrawable(DataGenerator.mTabRes[i]));
            textView.setTextColor(context.getResources().getColor(R.color.color_un_focused));
        }
    }

    public static void chooseFirst(Context context,TabLayout tabLayout) {
        TabLayout.Tab tabAt =  tabLayout.getTabAt(0);
        View view = tabAt.getCustomView();
        ImageView imageView = view.findViewById(R.id.tab_content_image);
        TextView textView = view.findViewById(R.id.tab_content_text);
        imageView.setImageDrawable(context.getResources().getDrawable(DataGenerator.mTabResPressed[0]));
        textView.setTextColor(context.getResources().getColor(R.color.color_focused));
    }

} 