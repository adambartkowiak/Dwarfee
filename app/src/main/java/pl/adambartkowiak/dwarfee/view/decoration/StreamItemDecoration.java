package pl.adambartkowiak.dwarfee.view.decoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import pl.adambartkowiak.dwarfee.R;

/**
 * Created by adambartkowiak on 04.05.2017.
 */

public class StreamItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private int mSpace;

    public StreamItemDecoration(int space, int color) {
        mSpace = space;
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setStrokeWidth(space);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        // Add top margin only for the first line
        if (parent.getChildLayoutPosition(view) > 0) {
            outRect.top = mSpace;
        } else {
            outRect.top = parent.getResources().getDimensionPixelSize(R.dimen.brodcaster_detail_image_height);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        // we set the stroke width before, so as to correctly draw the line we have to offset by width / 2
        final int offset = (int) (mPaint.getStrokeWidth() / 2);

        // this will iterate over every visible view
        for (int i = 0; i < parent.getChildCount(); i++) {
            // get the view
            final View view = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();

            // get the position
            final int position = params.getViewAdapterPosition();

            // and finally draw the separator
            if (position < state.getItemCount()) {
                c.drawLine(view.getLeft(), view.getBottom() + offset, view.getRight(), view.getBottom() + offset, mPaint);
            }
        }

    }


}
