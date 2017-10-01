package com.example.guest.willow.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;
import com.example.guest.willow.adapters.FirebaseListingViewHolder;
import com.example.guest.willow.models.Listing;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedListingRecordActivity extends AppCompatActivity {
    private DatabaseReference mListingReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mListingReference = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_LISTINGS)
                .child(uid);

//        mListingReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LISTINGS);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Listing, FirebaseListingViewHolder>(Listing.class, R.layout.listing_record_item_drag, FirebaseListingViewHolder.class, mListingReference) {

            @Override
            protected void populateViewHolder(FirebaseListingViewHolder viewHolder, Listing model, int position) {
                viewHolder.bindListing(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
