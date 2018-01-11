package com.semilla.globallogic.ui.presenter;



import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.globallogic.model.Vegetable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.semilla.globallogic.ui.fragment.HomeView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class HomePresenter {

    private static int SQUARESIZE = 60;
    public static final String FIRST = "first";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    private Integer widthOchard;
    private Integer heigthOchard;
    private DatabaseReference mDatabase;

    List<Vegetable> vegetables = new ArrayList<>();
    HomeView homeView;


    public void  setHomeView(HomeView view){
        this.homeView = view;
    }

    public int getsquaresColum() {

        return ((heigthOchard * 100) / SQUARESIZE);
    }

    public int getsquaresFile() {

        return ((widthOchard * 100) / SQUARESIZE);

    }

    public int getWidth(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(WIDTH, MODE_PRIVATE);
        widthOchard = prefs.getInt(WIDTH, 2);
        return widthOchard;
    }

    public int getHeight(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(WIDTH, MODE_PRIVATE);
        heigthOchard = prefs.getInt(HEIGHT, 4);
        return heigthOchard;
    }

    public int squareSize() {
        return SQUARESIZE;
    }

    public List<Vegetable> getVegetables() {

        List<Vegetable> vegetablesData = new ArrayList<>();
        for (int i = 0; i < vegetables.size(); i++) {
            for (int j = 0; j < (getsquaresColum() / vegetables.size()) * getsquaresFile(); j++) {
                vegetablesData.add(vegetables.get(i));
            }
        }
        return vegetablesData;

    }

    public void initialize(Context context) {



        FirebaseDatabase.getInstance().getReference().child("vegetales").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                vegetables.removeAll(vegetables);
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    vegetables.add(new Vegetable(item.getKey(), item.getValue().toString()));
                }
                homeView.setVegetables();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Database", databaseError.toString());

            }
        });

        if (isFirstTime(context)) {
            SharedPreferences.Editor editor = context.getSharedPreferences(FIRST, MODE_PRIVATE).edit();
            editor.putBoolean("first", false);
            editor.apply();
        }
    }

    public Boolean isFirstTime(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(FIRST, MODE_PRIVATE);
        return prefs.getBoolean(FIRST, true);
    }

}
