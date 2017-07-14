package com.fc.fan.another.module.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.fan.another.R;

/**
 * Created by fan on 7/14/17.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    public static final String[] action = new String[]{"首页", "课程", "下载", "我的"};
    public static final Integer[] icon = new Integer[]{R.drawable.ic_home_color, R.drawable.ic_course_color
            , R.drawable.ic_download_color, R.drawable.ic_mine_color};

    private LayoutInflater inflater;

    public FragmentAdapter(FragmentManager fm, LayoutInflater inflater) {
        super(fm);
        this.inflater = inflater;
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(position + "");
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return action[position];
    }

    public View getTypeView(int position) {
        View view = inflater.inflate(R.layout.tab_item, null);
        TextView textView = view.findViewById(R.id.tab_textView);
        textView.setText(getPageTitle(position));
        ImageView imageView = view.findViewById(R.id.tab_imageView);
        imageView.setImageResource(icon[position]);
        return view;
    }
}
