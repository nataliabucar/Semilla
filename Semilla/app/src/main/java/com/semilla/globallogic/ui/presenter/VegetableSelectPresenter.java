package com.semilla.globallogic.ui.presenter;


import android.content.Context;
import android.util.Log;

import com.globallogic.model.Vegetable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.semilla.globallogic.ui.fragment.VegetableSelectView;

import java.util.ArrayList;
import java.util.List;

public class VegetableSelectPresenter {

    List<Vegetable> vegetablesStation = new ArrayList<>();
    List<Vegetable> vegetablesAnual = new ArrayList<>();
    VegetableSelectView vegetableSelectView;


    public void setVegetableSelectView(VegetableSelectView view) {
        this.vegetableSelectView = view;
    }

    public void initialize(Context context) {


        FirebaseDatabase.getInstance().getReference().child("vegetales_verano").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                vegetablesStation.removeAll(vegetablesStation);
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    vegetablesStation.add(new Vegetable(item.getKey(), item.getValue().toString()));
                }
                vegetableSelectView.setVegetablesByStation(vegetablesStation);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Database", databaseError.toString());

            }
        });


    }

    public void setVegetableInOchard(Vegetable vegetable) {

        FirebaseDatabase.getInstance().getReference().child("vegetales").child(vegetable.getName()).setValue(Integer.valueOf(vegetable.getId()));
    }
}
