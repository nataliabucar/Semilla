package com.semilla.globallogic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment{

    @Nullable
    @Override
    @CallSuper
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(makeLayoutResourceId(), container, false);
        ButterKnife.bind(this, fragmentView);

        doOnCreateView();
        return fragmentView;
    }

    protected void doOnCreateView() {
        // Do nothing by default here
    }

    protected abstract int makeLayoutResourceId();

}
