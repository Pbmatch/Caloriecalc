package com.calorie.calc;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;

import com.calorie.calc.utils.PicassoHelper;

public class App  extends Application {
    protected static final String TAG = App.class.toString();
    private static App app;
    public static final String PACKAGE_NAME = BuildConfig.APPLICATION_ID;



    @NonNull
    public static App getApp() {
        return app;
    }

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();


        app = this;
        PicassoHelper.init(this);
        PicassoHelper.setShouldLoadImages(true);
        PicassoHelper.setIndicatorsEnabled(MainActivity.DEBUG
                &&  false);



        // Check for new version

    }

    @Override
    public void onTerminate() {

        super.onTerminate();
    }













}
