package com.example.guest.willow.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel

public class Listing {
    String line1;
    String line2;
    String locality;
    double postal1;
    double latitude;
    double longitude;

    public Listing() {}

    public Listing(String line1, String line2, String locality, double postal1, double latitude, double longitude) {
        this.line1 = line1;
        this.line2 = line2;
        this.locality = locality;
        this.postal1 = postal1;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
