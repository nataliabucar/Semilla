package com.semilla.globallogic.ui.fragment;


import com.globallogic.model.Vegetable;

import java.util.List;

public interface VegetableSelectView {
    void setVegetablesByStation(List<Vegetable> vegetablesStation);

    void setVegetablesAnual(List<Vegetable> vegetablesAnual);
}
