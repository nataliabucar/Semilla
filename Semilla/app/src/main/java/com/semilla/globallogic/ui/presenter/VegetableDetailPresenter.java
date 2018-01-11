package com.semilla.globallogic.ui.presenter;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class VegetableDetailPresenter {

    public static final String SOW = "sow";


    public void saveSow(Context context, Boolean isSow) {
        SharedPreferences.Editor editor = context.getSharedPreferences(SOW, MODE_PRIVATE).edit();
        editor.putBoolean(SOW, isSow);
        editor.apply();
    }

    public boolean isSow(Context context) {

        return context.getSharedPreferences(SOW, MODE_PRIVATE).getBoolean(SOW, false);
    }
}
