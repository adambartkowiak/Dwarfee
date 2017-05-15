package pl.adambartkowiak.dwarfee.view.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import pl.adambartkowiak.dwarfee.R;

/**
 * Created by adambartkowiak on 04.05.2017.
 */

public class BroadcastersItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public BroadcastersItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first line
        if (parent.getChildLayoutPosition(view) < 2) {
            outRect.top = space;
        } else {
            outRect.top = 0;
        }

        //odd even
        if ((parent.getChildLayoutPosition(view) & 1) == 0) {
            outRect.right = space / 2;
        } else {
            outRect.left = space / 2;
        }
    }
}
