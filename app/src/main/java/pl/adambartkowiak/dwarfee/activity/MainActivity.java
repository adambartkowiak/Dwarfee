package pl.adambartkowiak.dwarfee.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.TypedValue;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

import pl.adambartkowiak.dwarfee.R;
import pl.adambartkowiak.dwarfee.fragment.BecomeBroadcasterFragment;
import pl.adambartkowiak.dwarfee.fragment.BroadcastersFragment;
import pl.adambartkowiak.dwarfee.fragment.CalendarFragment;
import pl.adambartkowiak.dwarfee.fragment.SettingsFragment;
import pl.adambartkowiak.dwarfee.fragment.StreamFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int mLastAnimationDecresseChange = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Add fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentHolder, new StreamFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (id == R.id.nav_stream) {
            ft.replace(R.id.fragmentHolder, new StreamFragment()).commit();
        } else if (id == R.id.nav_broadcasters) {
            ft.replace(R.id.fragmentHolder, new BroadcastersFragment()).commit();
        } else if (id == R.id.nav_calendar) {
            ft.replace(R.id.fragmentHolder, new CalendarFragment()).commit();
        } else if (id == R.id.nav_settings) {
            ft.replace(R.id.fragmentHolder, new SettingsFragment()).commit();
        } else if (id == R.id.nav_become_broadcaster) {
            ft.replace(R.id.fragmentHolder, new BecomeBroadcasterFragment()).commit();
        }

//        else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

//    public void onCheckboxClicked(View view) {
//        AppCompatCheckBox checkbox = (AppCompatCheckBox) view;
//        ViewGroup v = (ViewGroup) view.getParent();
//        View newsImage = v.findViewById(R.id.newsImage);
//        View description = v.findViewById(R.id.description);
//
//        if (checkbox.isChecked()) {
//            description.setVisibility(View.GONE);
//
//            mLastAnimationDecresseChange = v.getMeasuredHeight() - newsImage.getMeasuredHeight();
//
//            animateHeight(v, newsImage.getMeasuredHeight() + 20);
//        } else {
//            description.setVisibility(View.VISIBLE);
//            animateHeight(v, v.getMeasuredHeight() + mLastAnimationDecresseChange - 20);
//        }
//
//    }

    public void animateHeight(final View v, final int endHeight) {

        final int initialHeight = v.getMeasuredHeight();
        int duration = 250;
        Interpolator interpolator = new AccelerateDecelerateInterpolator();

        // I have to set the same height before the animation because there is a glitch
        // in the beginning of the animation
        v.getLayoutParams().height = initialHeight;
        v.requestLayout();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = (int) (initialHeight * (1 - interpolatedTime)) + (int) (endHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(duration);
        a.setInterpolator(interpolator);
        v.startAnimation(a);
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash #2");
    }

}
