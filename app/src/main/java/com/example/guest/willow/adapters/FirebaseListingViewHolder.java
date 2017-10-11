package com.example.guest.willow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.guest.willow.R;
import com.example.guest.willow.models.Listing;
import com.example.guest.willow.util.ItemTouchHelperViewHolder;

public class FirebaseListingViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    public TextView mListingLine1TextView;

    View mView;
    Context mContext;

    public FirebaseListingViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindListing(Listing listing) {
        mListingLine1TextView = (TextView) mView.findViewById(R.id.listingAddress1TextView);
        TextView line1TextView = (TextView) mView.findViewById(R.id.listingAddress1TextView);
        TextView line2TextView = (TextView) mView.findViewById(R.id.listingAddress2TextView);
        TextView localityTextView = (TextView) mView.findViewById(R.id.localityTextView);

        mListingLine1TextView.setText(listing.getLine1());
        line1TextView.setText(listing.getLine1());
        line2TextView.setText(listing.getLine2());
        localityTextView.setText(listing.getLocality());
    }

    @Override
    public void onItemSelected() {
        Log.d("Animation", "onItemSelected");
        itemView.animate()
                .alpha(0.7f)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setDuration(500);
    }

    @Override
    public void onItemClear() {
        Log.d("Animation", "onItemClear");
        itemView.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f);
    }

//    @Override
//    public void onClick(View view) {
//        final ArrayList<Listing> listings = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_LISTINGS);
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    listings.add(snapshot.getValue(Listing.class));
//                }
//
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(mContext, ListingDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("listings", Parcels.wrap(listings));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//            }
//        });
//    }
}