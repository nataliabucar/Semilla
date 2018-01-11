package com.semilla.globallogic.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.globallogic.model.Vegetable;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.activity.WizardActivity;
import com.semilla.globallogic.ui.adapter.VegetableAdapter;
import com.semilla.globallogic.ui.presenter.VegetableDetailPresenter;
import com.semilla.globallogic.ui.presenter.VegetableSelectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class VegetableSelectFragment extends BaseFragment implements VegetableSelectView, VegetableAdapter.VegetableAdapterInterface {


    @BindView(R.id.recycler_vegetables)
    RecyclerView vVegetablesRecycler;
    VegetableAdapter vegetableAdapter;
    VegetableSelectPresenter presenter;


    public static Fragment newInstance() {

        return new VegetableSelectFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new VegetableSelectPresenter();
        presenter.setVegetableSelectView(this);
        vVegetablesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        vegetableAdapter = new VegetableAdapter(this.getContext());
        vegetableAdapter.setVegetableAdapterInterface(this);
        vVegetablesRecycler.setAdapter(vegetableAdapter);
        presenter.initialize(getContext());
    }


    @Override
    protected int makeLayoutResourceId() {
        return R.layout.vegetable_select_fragment;
    }

    @OnClick({R.id.tv_next, R.id.tv_cancel})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                getActivity().finish();
                break;
            case R.id.tv_cancel:
                getActivity().finish();
                break;
            default:
                Log.w(this.getTag(), "Not Defined Option");
                break;
        }
    }

    @Override
    public void setVegetablesByStation(List<Vegetable> vegetablesStation) {

        vegetableAdapter.setVegetables(vegetablesStation);

    }

    @Override
    public void setVegetablesAnual(List<Vegetable> vegetablesAnual) {

    }

    @Override
    public void vegetablePressed(Vegetable vegetable) {
        presenter.setVegetableInOchard(vegetable);
    }
}
