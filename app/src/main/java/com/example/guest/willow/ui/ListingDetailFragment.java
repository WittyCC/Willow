package com.example.guest.willow.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.willow.R;
import com.example.guest.willow.models.Listing;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListingDetailFragment extends Fragment {
    @Bind(R.id.line1TextView) TextView mLine1Label;
    @Bind(R.id.line2TextView) TextView mLine2Label;
    @Bind(R.id.localityTextView) TextView mLocalityLabel;

    private Listing mListing;

    public static ListingDetailFragment newInstance(Listing listing) {
        ListingDetailFragment listingDetailFragment = new ListingDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("listing", Parcels.wrap(listing));
        listingDetailFragment.setArguments(args);
        return listingDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListing = Parcels.unwrap(getArguments().getParcelable("listing"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listing_detail, container, false);
        ButterKnife.bind(this, view);

        mLine1Label.setText(mListing.getLine1());
        mLine2Label.setText(mListing.getLine2());
        mLocalityLabel.setText(mListing.getLocality());
        return inflater.inflate(R.layout.fragment_listing_detail, container, false);
    }

}
