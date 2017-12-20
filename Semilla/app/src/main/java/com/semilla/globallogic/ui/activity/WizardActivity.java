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

import butterknife.ButterKnife;



public class WizardActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);
        ButterKnife.bind(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        init();
    }

    public static Intent getIntent(Context context){
        return  new Intent(context, WizardActivity.class);
    }

    private void init() {

        replaceFragment(R.id.main_fragment_container, GroundFragment.newInstance());


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
