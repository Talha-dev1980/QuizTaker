package com.quizapp.Utils;

import android.content.Context;
import android.util.Log;

import com.quizapp.BuildConfig;


public class AppLogger {
    private static AppLogger mInstance = null;
    private Context context;

    private AppLogger(Context context) {
        this.context = context;
    }

    public static void init(Context context) {
        mInstance = new AppLogger(context);
    }

    public static void log(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }
}
