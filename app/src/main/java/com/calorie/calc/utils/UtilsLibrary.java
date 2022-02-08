package com.calorie.calc.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class UtilsLibrary {
  public   static Boolean isNetworkAvailable(Context context) {
        Boolean res = false;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null) {
                res = networkInfo.isConnected();
            }
        }

        return res;
    }
}
