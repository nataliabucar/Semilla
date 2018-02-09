package com.semilla.globallogic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.globallogic.model.Vegetable;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.activity.VegetableDetailActivity;
import com.semilla.globallogic.ui.activity.WizardActivity;
import com.semilla.globallogic.ui.adapter.OchardAdapter;
import com.semilla.globallogic.ui.presenter.HomePresenter;
import com.semilla.globallogic.ui.util.SharedPrefsUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment implements OchardAdapter.OchardAdapterInterface, HomeView {

    @BindView(R.id.ll_container_orchard)
    RecyclerView vOrchardRecycler;
    @BindView(R.id.tv_mts_width)
    TextView vMtsWidht;
    @BindView(R.id.tv_mts_height)
    TextView vMtsHeight;
    @BindView(R.id.tv_title)
    TextView vTtitle;
    @BindView(R.id.tv_title_calendar_month)
    TextView vMonth;

    private HomePresenter homePresenter;

    private OchardAdapter ochardAdaper;

    public static Fragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homePresenter = new HomePresenter();
        homePresenter.setHomeView(this);
        init();
        homePresenter.initialize(getContext());

    }

    @Override
    public void onResume() {
        super.onResume();
        if (homePresenter != null) {
            drawOchard();
        }
    }


    private void init() {
        vMonth.setText(new SimpleDateFormat("MMM").format(Calendar.getInstance().getTime()));
        vTtitle.setText(!homePresenter.isFirstTime(getContext()) ? getResources().getString(R.string.basic_ochard) : getResources().getString(R.string.welcome));
        vMtsHeight.setText(String.format(getString(R.string.mts), homePresenter.getHeight(getContext())));
        vMtsWidht.setText(String.format(getString(R.string.mts), homePresenter.getWidth(getContext())));
        vOrchardRecycler.setLayoutManager(new GridLayoutManager(this.getContext(), homePresenter.getsquaresColum()));
        ochardAdaper = new OchardAdapter(this.getContext());
        ochardAdaper.setOchardAdapterInterface(this);
        vOrchardRecycler.setAdapter(ochardAdaper);
        drawOchard();
    }

    @Override
    protected int makeLayoutResourceId() {
        return R.layout.home_fragment;
    }

    @OnClick({R.id.tv_edit_ochard})
    public void onClicked(View view) {
        getActivity().startActivity(WizardActivity.getIntent(getActivity(), false));
    }


    @Override
    public void vegetablePressed(Vegetable vegetable) {
        getActivity().startActivity(VegetableDetailActivity.getIntent(getActivity(), vegetable.getName()));
    }

    private void drawOchard() {
        vMtsHeight.setText(String.format(getString(R.string.mts), homePresenter.getHeight(getContext())));
        vMtsWidht.setText(String.format(getString(R.string.mts), homePresenter.getWidth(getContext())));
        ochardAdaper.setVegetables(homePresenter.getVegetables());

    }

    @Override
    public void setVegetables() {
        ochardAdaper.setVegetables(homePresenter.getVegetables());
    }
}
