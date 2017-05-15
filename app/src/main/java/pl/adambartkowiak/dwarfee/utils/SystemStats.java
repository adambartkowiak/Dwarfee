package pl.adambartkowiak.dwarfee.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Window;

/**
 * Created by adambartkowiak on 15.05.2017.
 */

public class SystemStats {

    public static int statusBarHeight = 0;

    public static void update(Activity activity) {
        statusBarHeight = getSoftButtonsBarHeight(activity);
    }

    @SuppressLint("NewApi")
    private static int getSoftButtonsBarHeight(Activity activity) {
//        // API 17+
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
//            DisplayMetrics metrics = new DisplayMetrics();
//            activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
//            int usableHeight = metrics.heightPixels;
//            activity.getWindowManager().getDefaultDisplay().getRealMetrics(metrics);
//            int realHeight = metrics.heightPixels;
//            if (realHeight > usableHeight)
//                return realHeight - usableHeight;
//            else
//                return 0;
//        }
//        return 0;
//
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;


    }

}
