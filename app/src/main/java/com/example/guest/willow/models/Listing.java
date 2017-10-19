package com.example.guest.willow.models;

import org.parceler.Parcel;

@Parcel

public class Listing {
    String line1;
    String line2;
    String locality;
    double postal1;
    double latitude;
    double longitude;
    private String pushId;
    String index;

    public Listing() {}

    public Listing(String line1, String line2, String locality, double postal1, double latitude, double longitude) {
        this.line1 = line1;
        this.line2 = line2;
        this.locality = locality;
        this.postal1 = postal1;
        this.latitude = latitude;
        this.longitude = longitude;
        this.index = "not_specified";
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getLocality() {
        return locality;
    }

    public double getPostal1() {
        return postal1;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getmLongitude() {
        return longitude;
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
