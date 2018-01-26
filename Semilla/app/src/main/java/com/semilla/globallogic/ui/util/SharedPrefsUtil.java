package com.semilla.globallogic.ui.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author gino.ghiotto
 */
public class SharedPrefsUtil {

    public static final String FIRST_RUN_KEY = "FIRST_RUN_KEY";

    private static SharedPreferences.Editor getEditor(Context context) {
        return SharedPrefsUtil.getSharedPreferences(context).edit();
    }

    private static SharedPreferences getSharedPreferences(String name, Context context) {
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return SharedPrefsUtil.getSharedPreferences(context.getPackageName(), context);
    }

    public static boolean hasPreference(String key, Context context) {
        return SharedPrefsUtil.getSharedPreferences(context).contains(key);
    }

    public static void savePreference(String key, Boolean value, Context context) {
        if (value != null && key != null) {
            SharedPreferences.Editor editor = SharedPrefsUtil.getEditor(context);
            editor.putBoolean(key, value);

            editor.commit();
        }
    }

    public static Boolean loadPreferenceAsBoolean(String key,
                                                  Boolean defaultValue, Context context) {
        Boolean value = defaultValue;
        if (key != null && SharedPrefsUtil.hasPreference(key, context)) {
            value = SharedPrefsUtil.getSharedPreferences(context).getBoolean(
                    key, false);
        }
        return value;
    }
}
