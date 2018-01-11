package com.semilla.globallogic.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.presenter.VegetableDetailPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class VegetableDetailActivity extends AppCompatActivity {

    @BindView(R.id.v_sow_selected)
    View vSowSelected;
    @BindView(R.id.v_seed_selected)
    View vSeedSelected;
    @BindView(R.id.v_evolution_selected)
    View vEvolutionSelected;
    @BindView(R.id.ll_sod_view)
    LinearLayout vSodView;
    @BindView(R.id.ll_evolution_view)
    LinearLayout vEvolutionView;
    @BindView(R.id.scroll_view)
    ScrollView vScrollView;
    @BindView(R.id.cb_is_sow)
    CheckBox vCheckSow;

    VegetableDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_detail);
        ButterKnife.bind(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        presenter = new VegetableDetailPresenter();
        vCheckSow.setChecked(presenter.isSow(this));


    }

    public static Intent getIntent(Context context) {
        return new Intent(context, VegetableDetailActivity.class);
    }


    @OnClick(R.id.ll_seed_container)
    public void onClickSeed() {
        vScrollView.scrollTo(0,0);
        vSeedSelected.setVisibility(View.VISIBLE);
        vSowSelected.setVisibility(View.GONE);
        vEvolutionSelected.setVisibility(View.GONE);
    }

    @OnClick(R.id.ll_sod_container)
    public void onClickSow() {
        int nY_Pos = vSodView.getTop();
        vScrollView.scrollTo(0,nY_Pos);
        vSeedSelected.setVisibility(View.GONE);
        vSowSelected.setVisibility(View.VISIBLE);
        vEvolutionSelected.setVisibility(View.GONE);
    }

    @OnClick(R.id.ll_evolution_container)
    public void onClickEvolution() {
        int nY_Pos = vEvolutionView.getTop();
        vScrollView.scrollTo(0,nY_Pos);
        vSeedSelected.setVisibility(View.GONE);
        vSowSelected.setVisibility(View.GONE);
        vEvolutionSelected.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.cb_is_sow)
    public void onClickCheckBox(){
        presenter.saveSow(this, vCheckSow.isChecked());
    }

}
