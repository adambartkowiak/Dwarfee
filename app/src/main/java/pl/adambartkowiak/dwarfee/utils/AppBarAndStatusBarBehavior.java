package pl.adambartkowiak.dwarfee.utils;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * Created by adambartkowiak on 11.05.2017.
 */

public class AppBarAndStatusBarBehavior extends CoordinatorLayout.Behavior<ViewGroup> {

    private static final int NOT_SET = -1;
    private int headerLayoutInitHeight = NOT_SET;
    private int scrollTotalDelta = 0;

    public AppBarAndStatusBarBehavior() {
    }

    public AppBarAndStatusBarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, ViewGroup child, View directTargetChild, View target, int nestedScrollAxes) {
//
//        final ViewGroup finalChild = child;
//        RecyclerView recyclerView = (RecyclerView) target;
//
//        if (headerLayoutInitHeight == NOT_SET) {
//            headerLayoutInitHeight = child.getHeight();
//
//            recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//                @Override
//                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                    super.onScrolled(recyclerView, dx, dy);
//
//                    scrollTotalDelta += dy;
//
//                    ViewGroup.LayoutParams params = finalChild.getLayoutParams();
//                    params.height = Math.max(headerLayoutInitHeight - scrollTotalDelta, 0);
//
//                    finalChild.requestLayout();
//                }
//            });
//        }
//        return true;
//    }
}
