package com.globallogic.model;

import java.io.Serializable;
import java.io.SerializablePermission;

/**
 * Created by Natalia.Bucar on 12/4/2017.
 */

public class Vegetable implements Serializable {

    private String name;

    private String id;

    public Vegetable(String vegetable, String id) {
        this.name = vegetable;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
