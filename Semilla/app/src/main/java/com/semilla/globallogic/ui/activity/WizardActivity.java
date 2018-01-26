package com.semilla.globallogic.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.fragment.GroundFragment;
import com.semilla.globallogic.ui.fragment.GroundSizeFragment;
import com.semilla.globallogic.ui.util.SharedPrefsUtil;

import butterknife.ButterKnife;



public class WizardActivity  extends AppCompatActivity {

    private static boolean mIsFromMenu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);
        ButterKnife.bind(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        init();
    }

    public static Intent getIntent(Context context, boolean isFromMenu){
        mIsFromMenu = isFromMenu;
        return  new Intent(context, WizardActivity.class);
    }

    private void init() {
        boolean isFirstRun = SharedPrefsUtil.loadPreferenceAsBoolean(SharedPrefsUtil.FIRST_RUN_KEY, true, WizardActivity.this);
        if (isFirstRun || mIsFromMenu) {
            replaceFragment(R.id.main_fragment_container, GroundFragment.newInstance());
            SharedPrefsUtil.savePreference(SharedPrefsUtil.FIRST_RUN_KEY, false, WizardActivity.this);

        } else {
            replaceFragment(R.id.main_fragment_container, GroundSizeFragment.newInstance());
        }


    }

    protected void replaceFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    public void setNextFragment(Fragment fragment) {
        replaceFragment(R.id.main_fragment_container, fragment);
    }

}
