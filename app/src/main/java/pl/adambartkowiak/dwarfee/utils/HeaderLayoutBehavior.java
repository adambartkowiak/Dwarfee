package pl.adambartkowiak.dwarfee.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import pl.adambartkowiak.dwarfee.R;

/**
 * Created by adambartkowiak on 11.05.2017.
 */

public class HeaderLayoutBehavior extends CoordinatorLayout.Behavior<RelativeLayout> {

    public static final int DURATION = 200;

    private static final int NOT_SET = -1;
    private int headerLayoutInitHeight = NOT_SET;
    private int headerLayoutHeight = NOT_SET;
    private boolean headerLayoutVisible = true;

    private int appbarLayoutInitHeight = NOT_SET;
    private boolean appbarLayoutVisible = true;

    private int appbarPaddingTop = SystemStats.statusBarHeight;
    private int scrollTotalDelta = 0;

    private boolean canCollapseToolbar = false;

    private static boolean startedTransitionAppbarAnimation = false;


    public HeaderLayoutBehavior() {
    }

    public HeaderLayoutBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, RelativeLayout child, View directTargetChild, View target, int nestedScrollAxes) {

        final RelativeLayout finalChild = child;
        final CoordinatorLayout finalCoordinatorLayout = coordinatorLayout;
        final Animations animations = new Animations();
        final TransitionDrawable transitionDrawable = (TransitionDrawable) coordinatorLayout.findViewById(R.id.appbar).getBackground();
        RecyclerView recyclerView = (RecyclerView) target;

        if (headerLayoutInitHeight == NOT_SET) {
            headerLayoutInitHeight = child.getHeight();
            appbarLayoutInitHeight = finalCoordinatorLayout.findViewById(R.id.appbar).getHeight();

            recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    scrollTotalDelta += dy;

                    //Header - ParalaxImage
                    ViewGroup.LayoutParams params = finalChild.getLayoutParams();
                    params.height = headerLayoutHeight = Math.max(headerLayoutInitHeight - scrollTotalDelta, 0);


                    //check toolbar collapse
                    canCollapseToolbar = (headerLayoutHeight < appbarLayoutInitHeight) ? true : false;

                    //Change appbarPaddingTop
                    if (canCollapseToolbar) {
                        appbarPaddingTop -= dy;

                        //Trick: Move appbar to min position when is out of the screen
                        if (dy < 0 && appbarPaddingTop < -appbarLayoutInitHeight + SystemStats.statusBarHeight * 2) {
                            appbarPaddingTop = -appbarLayoutInitHeight + SystemStats.statusBarHeight * 2;
                        }

                    } else if (dy < 0) {
                        appbarPaddingTop -= dy;
                    }

                    //Max-Min PaddingTop value
                    appbarPaddingTop = Math.max(appbarPaddingTop, -appbarLayoutInitHeight + SystemStats.statusBarHeight);
                    appbarPaddingTop = Math.min(appbarPaddingTop, SystemStats.statusBarHeight);

                    //Check visibility
                    headerLayoutVisible = (headerLayoutHeight > 0) ? true : false;
                    appbarLayoutVisible = (appbarPaddingTop == -appbarLayoutInitHeight + SystemStats.statusBarHeight) ? false : true;


                    AppBarLayout appbar = (AppBarLayout) finalCoordinatorLayout.findViewById(R.id.appbar);
                    AppCompatTextView toolbarTitle = (AppCompatTextView) appbar.findViewById(R.id.toolbar_title);

                    //StatusBar
                    Activity host = (Activity) recyclerView.getContext();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        //status bar color
                        if (scrollTotalDelta > headerLayoutInitHeight - appbarLayoutInitHeight) {
                            int colorFrom = host.getWindow().getStatusBarColor();
                            int colorTo = host.getResources().getColor(R.color.colorPrimaryDark);

                            animations.statusBarBackgroundColorAnimation(host, colorFrom, colorTo, DURATION);
                        } else {
                            int colorFrom = host.getWindow().getStatusBarColor();
                            int colorTo = host.getResources().getColor(R.color.transparent);

                            animations.statusBarBackgroundColorAnimation(host, colorFrom, colorTo, DURATION);
                        }
                    }

                    //toolbar color
                    if (headerLayoutHeight - appbarPaddingTop < appbarLayoutInitHeight - SystemStats.statusBarHeight) {
                        if (!startedTransitionAppbarAnimation) {
                            startedTransitionAppbarAnimation = true;
                            transitionDrawable.startTransition(DURATION);
                        }
                        toolbarTitle.setVisibility(View.VISIBLE);

                    } else {
                        if (startedTransitionAppbarAnimation) {
                            startedTransitionAppbarAnimation = false;
                            transitionDrawable.reverseTransition(DURATION);
                        }


                        toolbarTitle.setVisibility(View.INVISIBLE);
                    }

                    //requestsLayout
                    finalChild.requestLayout();

                    appbar.setPadding(0, appbarPaddingTop, 0, 0);
                    appbar.requestLayout();
                }
            });
        }
        return true;
    }

}
