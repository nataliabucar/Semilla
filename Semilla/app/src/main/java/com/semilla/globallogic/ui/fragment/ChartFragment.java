package com.semilla.globallogic.ui.fragment;

import android.support.v4.app.Fragment;

import com.semilla.globallogic.R;


public class ChartFragment extends BaseFragment {

    public static Fragment newInstance() {

        return new ChartFragment();
    }

    @Override
    protected int makeLayoutResourceId() {
        return R.layout.chart_fragment;
    }
}
