package pl.adambartkowiak.dwarfee.utils;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;

/**
 * Created by adambartkowiak on 15.05.2017.
 */

public class Animations {

    private int statusBarColorTargetColor = 0;
    private int backgroundColorTargetColor = 0;

    public void backgroundColorAnimation(View view, int colorFrom, int colorTo, int duration) {

        if (backgroundColorTargetColor == colorTo) {
            return;
        }
        backgroundColorTargetColor = colorTo;

        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        final View finalView = view;

        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                finalView.setBackgroundColor((Integer) animator.getAnimatedValue());
            }
        });

        colorAnimation.setDuration(duration);
        colorAnimation.setStartDelay(0);
        colorAnimation.start();
    }

    public void statusBarBackgroundColorAnimation(Activity activity, int colorFrom, int colorTo, int duration) {

        if (statusBarColorTargetColor == colorTo) {
            return;
        }
        statusBarColorTargetColor = colorTo;

        final Activity finalActivity = activity;
        ValueAnimator colorStatusAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);

        colorStatusAnimation.addUpdateListener(
                new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            finalActivity.getWindow().setStatusBarColor((Integer) animator.getAnimatedValue());
                        }
//                        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
//                            tintManager.setStatusBarTintColor((Integer) animator.getAnimatedValue());
//                        }
                    }

                });

        colorStatusAnimation.setDuration(duration);
        colorStatusAnimation.setStartDelay(0);
        colorStatusAnimation.start();
    }
}
