package com.example.guest.willow.models;

public class Listing {
    private String mLine1;
    private String mLine2;
    private String mLocality;
    private double mPostal1;
    private double mLatitude;
    private double mLongitude;

    public Listing(String line1, String line2, String locality, double postal1, double latitude, double longitude) {
        this.mLine1 = line1;
        this.mLine2 = line2;
        this.mLocality = locality;
        this.mPostal1 = postal1;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
    }

    public String getLine1() {
        return mLine1;
    }

    public String getLine2() {
        return mLine2;
    }

    public String getLocality() {
        return mLocality;
    }

    public double getPostal1() {
        return mPostal1;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getmLongitude() {
        return mLongitude;
    }
}
