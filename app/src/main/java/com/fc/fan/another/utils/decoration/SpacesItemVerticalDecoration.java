package com.fc.fan.another.utils.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by fan on 7/23/17.
 */

public class SpacesItemVerticalDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemVerticalDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
    }
}