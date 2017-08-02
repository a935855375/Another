package com.fc.fan.another.utils.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fc.fan.another.adpater.NewMainAdapter;

import static com.fc.fan.another.adpater.NewMainAdapter.COURSE_CARD;
import static com.fc.fan.another.adpater.NewMainAdapter.PLAN_CARD;


public class MainItemDecoration extends RecyclerView.ItemDecoration {

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        int location = parent.getChildAdapterPosition(view);
        int type = NewMainAdapter.getInstance().getItemViewType(location);

        if (type == COURSE_CARD || type == PLAN_CARD) {
            int realLocation = NewMainAdapter.getInstance().getRealLocation(location);

            outRect.bottom = 30;
            if (realLocation % 2 == 1) {
                outRect.left = 15;
                outRect.right = 35;
            } else {
                outRect.left = 35;
                outRect.right = 15;
            }
        }
    }
}