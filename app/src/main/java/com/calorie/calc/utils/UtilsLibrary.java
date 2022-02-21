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
    public static boolean isBlank(final String string) {
        if (isNullOrEmpty(string)) {
            return true;
        }

        final int length = string.length();
        for (int i = 0; i < length; i++) {
            if (!isWhitespace(string.codePointAt(i))) {
                return false;
            }
        }

        return true;
    }
    public static boolean isNullOrEmpty(final String str) {
        return str == null || str.isEmpty();
    }
    public static boolean isWhitespace(final int c) {
        return c == ' ' || c == '\t' || c == '\n' || c == '\f' || c == '\r';
    }
}
