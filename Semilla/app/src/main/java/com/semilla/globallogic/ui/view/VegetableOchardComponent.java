package com.semilla.globallogic.ui.view;


import android.content.Context;
import android.widget.LinearLayout;

import com.semilla.globallogic.R;

import butterknife.ButterKnife;

public class VegetableOchardComponent extends LinearLayout{

    public VegetableOchardComponent(Context context) {
        super(context);
        initialize(context);
    }

    private void initialize(Context context) {
        inflate(context, R.layout.view_vegetable_ochard, this);
        ButterKnife.bind(this);
    }
}
