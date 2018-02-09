package com.semilla.globallogic.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.GoogleMap;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.fragment.ChartFragment;
import com.semilla.globallogic.ui.fragment.HomeFragment;
import com.semilla.globallogic.ui.fragment.SocialFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.iv_ochard_tab)
    ImageView vOchardTab;

    @BindView(R.id.iv_community_tab)
    ImageView vCommunityTab;

    @BindView(R.id.iv_data_tab)
    ImageView vDataTab;

    private GoogleMap mMap;

    private GoogleApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        init();
    }

    private void init() {

        replaceFragment(R.id.main_fragment_container, HomeFragment.newInstance());
        vOchardTab.setSelected(true);
        vCommunityTab.setSelected(false);
        vDataTab.setSelected(false);


    }

    protected void replaceFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, fragment.getClass().getName());
        fragmentTransaction.commit();
    }

    @OnClick(R.id.ll_home)
    public void onClickHome(){
        replaceFragment(R.id.main_fragment_container, HomeFragment.newInstance());
        vOchardTab.setSelected(true);
        vCommunityTab.setSelected(false);
        vDataTab.setSelected(false);
    }

    @OnClick(R.id.ll_social)
    public void onClickSocial(){
        replaceFragment(R.id.main_fragment_container, SocialFragment.newInstance());
        vOchardTab.setSelected(false);
        vCommunityTab.setSelected(true);
        vDataTab.setSelected(false);
    }

    @OnClick(R.id.ll_chart)
    public void onClickChart(){
        replaceFragment(R.id.main_fragment_container, ChartFragment.newInstance());
        vOchardTab.setSelected(false);
        vCommunityTab.setSelected(false);
        vDataTab.setSelected(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_start:
                return true;
            case R.id.action_seed:
                return true;
            case R.id.action_tutorials:
                startActivity(TutorialActivity.getIntent(this));
                return true;
            case R.id.action_edit:
                startActivity(WizardActivity.getIntent(this, true));
                return true;
            case R.id.action_recipes:
                return true;
            case R.id.action_login:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
