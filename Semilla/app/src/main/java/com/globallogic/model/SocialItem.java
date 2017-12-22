package com.globallogic.model;

import java.io.Serializable;

/**
 * @author gino.ghiotto
 * @since 4.22
 */
public class SocialItem implements Serializable{

    public SocialItem(String name, String shares, String distance) {
        this.name = name;
        this.shares = shares;
        this.distance = distance;
    }

    private String name;
    private String shares;
    private String distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
