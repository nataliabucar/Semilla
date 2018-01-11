package com.semilla.globallogic.ui.view;


import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.semilla.globallogic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

public class VegetableOchardComponent extends LinearLayout{

    public static final String SOW = "sow";

    @BindView(R.id.iv_sing)
    ImageView vSing;

    public VegetableOchardComponent(Context context) {
        super(context);
        initialize(context);
    }

    private void initialize(Context context) {
        inflate(context, R.layout.view_vegetable_ochard, this);
        ButterKnife.bind(this);
        vSing.setVisibility(context.getSharedPreferences(SOW, MODE_PRIVATE).getBoolean(SOW, false)? GONE : VISIBLE);
    }
}
