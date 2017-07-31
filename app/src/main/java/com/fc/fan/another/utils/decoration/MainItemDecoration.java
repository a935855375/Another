package com.fc.fan.another.utils.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = 30;

        if (parent.getChildLayoutPosition(view) > 1) {
            if (parent.getChildLayoutPosition(view) % 2 == 1) {
                outRect.left = 15;
                outRect.right = 35;
            } else {
                outRect.left = 35;
                outRect.right = 15;
            }

        }

    }
}