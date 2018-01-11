package com.semilla.globallogic.ui.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.OnClick;


public class ChartFragment extends BaseFragment {


    @BindView(R.id.v_seed_selected)
    View vFoodSelected;
    @BindView(R.id.v_sow_selected)
    View vProductionSelected;
    @BindView(R.id.iv_image_food_fragment)
    ImageView vFoodContainer;
    @BindView(R.id.iv_image_production_fragment)
    ImageView vProductionContainer;

    public static Fragment newInstance() {

        return new ChartFragment();
    }

    @Override
    protected int makeLayoutResourceId() {
        return R.layout.chart_fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vFoodContainer.setVisibility(View.VISIBLE);
        vProductionContainer.setVisibility(View.GONE);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.ll_food_container)
    public void onClickSeed() {
        vFoodSelected.setVisibility(View.VISIBLE);
        vProductionSelected.setVisibility(View.GONE);
        vFoodContainer.setVisibility(View.VISIBLE);
        vProductionContainer.setVisibility(View.GONE);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick(R.id.ll_production_container)
    public void onClickSow() {
        vFoodSelected.setVisibility(View.GONE);
        vProductionSelected.setVisibility(View.VISIBLE);
        vFoodContainer.setVisibility(View.GONE);
        vProductionContainer.setVisibility(View.VISIBLE);

    }

}
