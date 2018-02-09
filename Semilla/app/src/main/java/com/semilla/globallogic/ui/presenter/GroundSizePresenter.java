package com.semilla.globallogic.ui.presenter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class GroundSizePresenter {

    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";

    public int getWidth(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(WIDTH, MODE_PRIVATE);
        return prefs.getInt(WIDTH, 2);
    }

    public int getHeight(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(WIDTH, MODE_PRIVATE);
        return prefs.getInt(HEIGHT, 4);
    }

    public void saveWidthAndHeight(Context context, Integer height, Integer width) {
        if (height != null || width != null) {
            SharedPreferences.Editor editor = context.getSharedPreferences(WIDTH, MODE_PRIVATE).edit();
            editor.putInt(WIDTH, width);
            editor.putInt(HEIGHT, height);
            editor.apply();
        }
    }
}
