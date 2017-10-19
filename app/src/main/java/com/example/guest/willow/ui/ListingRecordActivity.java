package com.example.guest.willow.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;
import com.example.guest.willow.models.Listing;
import com.example.guest.willow.util.OnListingSelectedListener;

import org.parceler.Parcels;

import java.util.ArrayList;

public class ListingRecordActivity extends AppCompatActivity implements OnListingSelectedListener{
    private Integer mPosition;
    ArrayList<Listing> mListings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);

        if (savedInstanceState != null) {

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                mPosition = savedInstanceState.getInt(Constants.EXTRA_KEY_POSITION);
                mListings = Parcels.unwrap(savedInstanceState.getParcelable(Constants.EXTRA_KEY_LISTINGS));

                if (mPosition != null && mListings != null) {
                    Intent intent = new Intent(this, ListingDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, mPosition);
                    intent.putExtra(Constants.EXTRA_KEY_LISTINGS, Parcels.wrap(mListings));
                    startActivity(intent);
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (mPosition != null && mListings != null) {
            outState.putInt(Constants.EXTRA_KEY_POSITION, mPosition);
            outState.putParcelable(Constants.EXTRA_KEY_LISTINGS, Parcels.wrap(mListings));
        }
    }

    @Override
    public void onListingSelected(Integer position, ArrayList<Listing>listings) {
        mPosition = position;
        mListings = listings;
    }
}
