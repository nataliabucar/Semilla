package com.semilla.globallogic.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;

import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.activity.WizardActivity;

import butterknife.OnClick;

public class GroundFragment extends BaseFragment{



    public static Fragment newInstance() {

        return new GroundFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    protected int makeLayoutResourceId() {
        return R.layout.ground_fragment;
    }

    @OnClick({R.id.tv_next, R.id.tv_cancel})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                ((WizardActivity)getActivity()).setNextFragment(GroundSizeFragment.newInstance());
                break;
            case R.id.tv_cancel:
                getActivity().finish();
                break;
            default:
                Log.w(this.getTag(), "Not Defined Option");
                break;
        }
    }


}