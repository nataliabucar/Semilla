package com.globallogic.model;

import java.io.Serializable;
import java.io.SerializablePermission;

/**
 * Created by Natalia.Bucar on 12/4/2017.
 */

public class Vegetable implements Serializable {

    private String name;

    public Vegetable(String vegetable) {
        this.name = vegetable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
