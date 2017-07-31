package com.fc.fan.another.module.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.module.explore.ExploreFragment;
import com.fc.fan.another.module.main.NewMainFragment;
import com.fc.fan.another.module.mine.MineFragment;
import com.fc.fan.another.module.region.RegionFragment;


class FragmentAdapter extends FragmentPagerAdapter {
    private static final String[] action = new String[]{"首页", "课程", "浏览", "我的"};
    public static final Integer[] icon = new Integer[]{R.drawable.ic_home_color, R.drawable.ic_course_color
            , R.drawable.ic_explore_color, R.drawable.ic_mine_color};

    private LayoutInflater inflater;

    FragmentAdapter(FragmentManager fm, LayoutInflater inflater) {
        super(fm);
        this.inflater = inflater;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewMainFragment.newInstance();
            case 1:
                return RegionFragment.newInstance();
            case 2:
                return ExploreFragment.newInstance();
            case 3:
                return MineFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return action[position];
    }

    View getTypeView(int position) {
        View view = inflater.inflate(R.layout.tab_item, null);
        TextView textView = view.findViewById(R.id.tab_textView);
        textView.setText(getPageTitle(position));
        ImageView imageView = view.findViewById(R.id.tab_imageView);
        imageView.setImageResource(icon[position]);
        return view;
    }
}
