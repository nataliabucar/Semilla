package com.semilla.globallogic.ui.util;


import android.graphics.drawable.Drawable;

import com.semilla.globallogic.R;

public class VegetableUtil {

    public static int getIcon(Integer id) {
        int drawable = 0;
        switch (id) {
            case 1:
                drawable = R.drawable.batata;
                break;
            case 2:
                drawable = R.drawable.papa;
                break;
            case 3:
                drawable = R.drawable.zanahoria;
                break;
            case 4:
                drawable = R.drawable.arveja;
                break;
            case 5:
                drawable = R.drawable.champignon;
                break;
            case 15:
                drawable = R.drawable.puerro;
                break;
            case 16:
                drawable = R.drawable.pepino;
                break;
            case 18:
                drawable = R.drawable.rabanito;
                break;
            case 19:
                drawable = R.drawable.rabanito_morado;
                break;
            default:
                drawable = R.drawable.champignon;
                break;

        }
        return drawable;
    }
}
