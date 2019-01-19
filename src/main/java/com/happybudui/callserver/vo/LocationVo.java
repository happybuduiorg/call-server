package com.happybudui.callserver.vo;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class LocationVo {
    private double userLongitude;
    private double userLatitude;

    public LocationVo(double userLongitude, double userLatitude) {
        this.userLongitude = userLongitude;
        this.userLatitude = userLatitude;
    }

    public double getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(double userLongitude) {
        this.userLongitude = userLongitude;
    }

    public double getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(double userLatitude) {
        this.userLatitude = userLatitude;
    }
}
