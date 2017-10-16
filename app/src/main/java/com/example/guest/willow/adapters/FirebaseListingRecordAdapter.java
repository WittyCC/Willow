package com.example.guest.willow.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;
import com.example.guest.willow.adapters.FirebaseListingViewHolder;
import com.example.guest.willow.models.Listing;
import com.example.guest.willow.ui.ListingDetailActivity;
import com.example.guest.willow.ui.ListingDetailFragment;
import com.example.guest.willow.util.ItemTouchHelperAdapter;
import com.example.guest.willow.util.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Collections;

public class FirebaseListingRecordAdapter extends FirebaseRecyclerAdapter<Listing, FirebaseListingViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;
    private ChildEventListener mChildEventListener;
    private ArrayList<Listing> mListings = new ArrayList<>();
    private int mOrientation;

    public FirebaseListingRecordAdapter(Class<Listing> modelClass, int modelLayout, Class<FirebaseListingViewHolder> viewHolderClass, Query ref, OnStartDragListener onStartDragListener, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;

        mChildEventListener = mRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                mListings.add(dataSnapshot.getValue(Listing.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void populateViewHolder(final FirebaseListingViewHolder viewHolder, Listing model, int position) {
        viewHolder.bindListing(model);

        mOrientation = viewHolder.itemView.getResources().getConfiguration().orientation;
        if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            createDetailFragment(0);
        }

        viewHolder.mListingLine1TextView.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mOnStartDragListener.onStartDrag(viewHolder);
                }
                return false;
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int itemPosition = viewHolder.getAdapterPosition();
                if (mOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                    createDetailFragment(itemPosition);
                } else {
                    Intent intent = new Intent(mContext, ListingDetailActivity.class);
                    intent.putExtra(Constants.EXTRA_KEY_POSITION, itemPosition);
                    intent.putExtra(Constants.EXTRA_KEY_LISTINGS, Parcels.wrap(mListings));
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mListings, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        mListings.remove(position);
        getRef(position).removeValue();
    }

    private void setIndexInFirebase() {
        for(Listing listing : mListings) {
            int index = mListings.indexOf(listing);
            DatabaseReference ref = getRef(index);
            listing.setIndex(Integer.toString(index));
            ref.setValue(listing);
        }
    }

    @Override
    public void cleanup() {
        super.cleanup();
        setIndexInFirebase();
        mRef.removeEventListener(mChildEventListener);
    }

    private void createDetailFragment(int position) {
        ListingDetailFragment detailFragment = ListingDetailFragment.newInstance(mListings, position);
        FragmentTransaction ft = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.listingDetailContainer, detailFragment);
        ft.commit();
    }
}
