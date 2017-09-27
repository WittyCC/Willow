package com.example.guest.willow.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel

public class Listing {
    String mLine1;
    String mLine2;
    String mLocality;
    double mPostal1;
    double mLatitude;
    double mLongitude;

    public Listing() {}

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
