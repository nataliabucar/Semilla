package com.semilla.globallogic.ui.fragment;

import android.support.v4.app.Fragment;

import com.semilla.globallogic.R;

/**
 * @author gino.ghiotto
 */
public class TutorialsFragment extends BaseFragment{
    @Override
    protected int makeLayoutResourceId() {
        return R.layout.fragment_tutorials;
    }

    public static Fragment newInstance() {

        return new TutorialsFragment();
    }

}
