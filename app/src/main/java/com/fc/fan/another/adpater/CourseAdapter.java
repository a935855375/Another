package com.fc.fan.another.adpater;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fc.fan.another.module.common.TestFragment;

/**
 * Created by fan on 7/18/17.
 */

public class CourseAdapter extends FragmentPagerAdapter {

    private String[] title = new String[]{"章节", "详情", "评论", "问答"};


    public CourseAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(title[position]);
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


}
