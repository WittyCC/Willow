package com.example.guest.willow.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.willow.models.Listing;
import com.example.guest.willow.ui.ListingDetailFragment;

import java.util.ArrayList;

/**
 * Created by wccha on 9/26/2017.
 */

public class ListingPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Listing> mListings;

    public ListingPagerAdapter(FragmentManager fm, ArrayList<Listing> listings) {
        super(fm);
        mListings = listings;
    }

    @Override
    public Fragment getItem(int position) {
        return ListingDetailFragment.newInstance(mListings.get(position));
    }

    @Override
    public int getCount() {
        return mListings.size();
    }
    
    @Override
    public CharSequence getPageTitle(int position) {
        return mListings.get(position).getLine1();
    }
}
