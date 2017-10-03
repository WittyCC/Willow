package com.example.guest.willow.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;
import com.example.guest.willow.adapters.FirebaseListingRecordAdapter;
import com.example.guest.willow.adapters.FirebaseListingViewHolder;
import com.example.guest.willow.models.Listing;
import com.example.guest.willow.util.OnStartDragListener;
import com.example.guest.willow.util.SimpleItemTouchHelperCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedListingRecordActivity extends AppCompatActivity {
//    private DatabaseReference mListingReference;
//    private FirebaseListingRecordAdapter mFirebaseAdapter;
//    private ItemTouchHelper mItemTouchHelper;
//
//    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_listing_record);
//        ButterKnife.bind(this);

//        setUpFirebaseAdapter();
    }

//        mListingReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LISTINGS);
//        setUpFirebaseAdapter();


//    private void setUpFirebaseAdapter() {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        Query query = FirebaseDatabase.getInstance()
//                .getReference(Constants.FIREBASE_CHILD_LISTINGS)
//                .child(uid)
//                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

//        mListingReference = FirebaseDatabase
//                .getInstance()
//                .getReference(Constants.FIREBASE_CHILD_LISTINGS)
//                .child(uid);
//
//        mFirebaseAdapter = new FirebaseListingRecordAdapter(Listing.class, R.layout.listing_record_item_drag, FirebaseListingViewHolder.class, query, this, this);
//
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setAdapter(mFirebaseAdapter);
//
//        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
//        mItemTouchHelper = new ItemTouchHelper(callback);
//        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mFirebaseAdapter.cleanup();
//    }
//
//    @Override
//    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
//        mItemTouchHelper.startDrag(viewHolder);
//    }
}
