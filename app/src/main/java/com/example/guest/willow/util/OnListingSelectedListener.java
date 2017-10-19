package com.example.guest.willow.util;

import com.example.guest.willow.models.Listing;

import java.util.ArrayList;

public interface OnListingSelectedListener {
    public void onListingSelected(Integer position, ArrayList<Listing> listings);
}
