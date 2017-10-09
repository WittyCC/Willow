package com.example.guest.willow.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;
import com.example.guest.willow.models.Listing;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListingDetailFragment extends Fragment implements View.OnClickListener {

    @Bind(R.id.line1TextView) TextView mLine1Label;
    @Bind(R.id.line2TextView) TextView mLine2Label;
    @Bind(R.id.localityTextView) TextView mLocalityLabel;
    @Bind(R.id.saveListingButton) TextView mSaveListingButton;

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

        mLine1Label.setOnClickListener(this);

        mSaveListingButton.setOnClickListener(this);

        return view;
//        return inflater.inflate(R.layout.fragment_listing_detail, container, false);
    }

    @Override
    public void onClick(View v) {
        if (v == mLine1Label) {
            Intent line1Intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mListing.getLine1()));
            startActivity(line1Intent);
        }

        if (v == mSaveListingButton) {
            DatabaseReference listingRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_LISTINGS);
            listingRef.push().setValue(mListing);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
