package com.semilla.globallogic.ui.presenter;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class GroundSizePresenter {

    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";


    public void saveWidthAndHeight(Context context,  Integer height, Integer width) {
        SharedPreferences.Editor editor = context.getSharedPreferences(WIDTH, MODE_PRIVATE).edit();
        editor.putInt(WIDTH, width);
        editor.putInt(HEIGHT, height);
        editor.apply();
    }
}
