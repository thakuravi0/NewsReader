package com.sivanta.newsreader.MaterialTest;

import android.app.Application;
import android.content.Context;

/**
 * Created by chandan on 5/15/2017.
 */

public class MyApplication extends Application
{
    public static final String api_key="22a7f031ea4d463b82d6bfffac2ec47c";
    private static Application application=null;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }
    public static Application getApplication()
    {
        return application;
    }
    public static Context getAppContext()
    {
       return application.getApplicationContext();
    }
}
