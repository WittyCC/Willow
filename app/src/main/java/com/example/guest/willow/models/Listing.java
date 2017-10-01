package com.example.guest.willow.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel

public class Listing {
    String Line1;
    String Line2;
    String Locality;
    double Postal1;
    double Latitude;
    double Longitude;
    private String pushId;
    String index;

    public Listing() {}

    public Listing(String line1, String line2, String locality, double postal1, double latitude, double longitude) {
        this.Line1 = line1;
        this.Line2 = line2;
        this.Locality = locality;
        this.Postal1 = postal1;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.index = "not_specified";
    }

    public String getLine1() {
        return Line1;
    }

    public String getLine2() {
        return Line2;
    }

    public String getLocality() {
        return Locality;
    }

    public double getPostal1() {
        return Postal1;
    }

    public double getLatitude() {
        return Latitude;
    }

    public double getmLongitude() {
        return Longitude;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
