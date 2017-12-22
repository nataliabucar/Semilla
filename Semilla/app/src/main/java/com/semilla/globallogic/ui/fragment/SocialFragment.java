package com.semilla.globallogic.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.globallogic.model.SocialItem;
import com.semilla.globallogic.R;
import com.semilla.globallogic.ui.adapter.SocialAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author gino.ghiotto
 */
public class SocialFragment extends BaseFragment implements SocialAdapter.SocialAdapterInterface {

    @BindView(R.id.rv_social)
    RecyclerView vSocialRecycler;

    SocialAdapter adapter;

    List<SocialItem> itemsList;

    public static Fragment newInstance() {

        return new SocialFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemsList = new ArrayList<>();
        setSocialData();
        vSocialRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new SocialAdapter(this.getContext());
        adapter.setInterface(this);
        adapter.setItems(itemsList);
        vSocialRecycler.setAdapter(adapter);
    }

    private void setSocialData() {
        itemsList.add(new SocialItem("Juan", "semillas, plantines", "Distancia: 1 km."));
        itemsList.add(new SocialItem("Manuel", "semillas, terreno", "Distancia: 12 km."));
        itemsList.add(new SocialItem("Mariela", "plantines", "Distancia: 2 km."));
        itemsList.add(new SocialItem("Jose", "semillas", "Distancia: 11 km."));
        itemsList.add(new SocialItem("Ramiro", "semillas, terreno", "Distancia: 13 km."));
        itemsList.add(new SocialItem("Esteban", "semillas, plantines", "Distancia: 4 km."));
    }

    @Override
    protected int makeLayoutResourceId() {
        return R.layout.social_fragment;
    }

    @Override
    public void elementPressed(int id) {

    }
}
