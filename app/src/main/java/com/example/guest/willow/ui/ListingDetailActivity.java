package com.example.guest.willow.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.guest.willow.R;
import com.example.guest.willow.adapters.ListingPagerAdapter;
import com.example.guest.willow.models.Listing;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by wccha on 9/26/2017.
 */

public class ListingDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private ListingPagerAdapter adapterViewPager;
    ArrayList<Listing> mListings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_detail);
        ButterKnife.bind(this);

        mListings = Parcels.unwrap(getIntent().getParcelableExtra("listings"));

        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ListingPagerAdapter(getSupportFragmentManager(), mListings);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
