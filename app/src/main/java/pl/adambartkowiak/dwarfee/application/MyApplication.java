package pl.adambartkowiak.dwarfee.application;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.Stetho;

import io.fabric.sdk.android.Fabric;

/**
 * Created by adambartkowiak on 09.05.2017.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        Fabric.with(this, new Crashlytics());
    }
}
