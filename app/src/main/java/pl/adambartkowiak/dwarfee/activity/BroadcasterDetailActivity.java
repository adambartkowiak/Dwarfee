package pl.adambartkowiak.dwarfee.activity;

import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import pl.adambartkowiak.dwarfee.R;
import pl.adambartkowiak.dwarfee.utils.SystemStats;

import static pl.adambartkowiak.dwarfee.utils.SystemStats.*;

public class BroadcasterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcaster_detail);


        //Paint under StatusBar
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set manualy toolbar title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbarTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Broadcaster Name");

        //Add Back Button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //ActionBar
        AppBarLayout appbar = (AppBarLayout) findViewById(R.id.appbar);
        appbar.setPadding(0, SystemStats.statusBarHeight, 0, 0);

        //Toolbar and ActionBar
//        appbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_transition));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            appbar.setElevation(0f);
            this.getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
