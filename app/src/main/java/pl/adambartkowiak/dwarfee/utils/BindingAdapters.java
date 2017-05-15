package pl.adambartkowiak.dwarfee.utils;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.daimajia.swipe.SwipeLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Created by adambartkowiak on 08.05.2017.
 */

public class BindingAdapters {

//    SwipeLayout
    @BindingAdapter({"bind:enableSwipe"})
    public static void setSwipeEnabled(SwipeLayout view, Boolean value) {
        view.setSwipeEnabled(value);
    }

    @BindingAdapter({"bind:hideSwipe"})
    public static void startHideSwipeAnimation(SwipeLayout view, Boolean value) {
        if (value == true) {
            view.close();
        }
    }

//    ImageView
    @BindingAdapter({"bind:srcUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Context context = imageView.getContext();
        RequestCreator request = Picasso.with(context).load(url);
        request.into(imageView);
    }

}
