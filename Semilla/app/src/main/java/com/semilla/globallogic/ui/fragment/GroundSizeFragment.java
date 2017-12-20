package com.semilla.globallogic.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.globallogic.model.Vegetable;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.activity.WizardActivity;
import com.semilla.globallogic.ui.presenter.GroundSizePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class GroundSizeFragment extends BaseFragment {

    @BindView(R.id.tv_mts_width_size)
    EditText vWidthSize;
    @BindView(R.id.tv_mts_height_size)
    EditText vHeightSize;

    GroundSizePresenter presenter;

    public static Fragment newInstance() {

        return new GroundSizeFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         presenter = new GroundSizePresenter();

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    @Override
    protected int makeLayoutResourceId() {
        return R.layout.ground_size_fragment;
    }

    @OnClick({R.id.tv_next, R.id.tv_cancel})
    public void onClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_next:
                presenter.saveWidthAndHeight(getContext(), Integer.valueOf(vWidthSize.getText().toString()), Integer.valueOf(vHeightSize.getText().toString()));
                ((WizardActivity)getActivity()).setNextFragment(VegetableSelectFragment.newInstance());
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
