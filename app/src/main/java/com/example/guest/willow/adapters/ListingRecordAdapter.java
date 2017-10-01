package com.example.guest.willow.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guest.willow.R;
import com.example.guest.willow.models.Listing;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListingRecordAdapter extends RecyclerView.Adapter<ListingRecordAdapter.ListingViewHolder> {
    private ArrayList<Listing> mListings = new ArrayList<>();
    private Context mContext;

    public ListingRecordAdapter(Context context, ArrayList<Listing> listings) {
        mContext = context;
        mListings = listings;
    }

    @Override
    public ListingRecordAdapter.ListingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_property_item, parent, false);
        ListingViewHolder viewHolder = new ListingViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListingViewHolder holder, int position) {
        holder.bindListing(mListings.get(position));
    }

    @Override
    public int getItemCount() {
        return mListings.size();
    }

    public class ListingViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.listingAddress1TextView) TextView mAddress1TextView;
        @Bind(R.id.listingAddress2TextView) TextView mAddress2TextView;
        @Bind(R.id.listingLocalityTextView) TextView mLocalityTextView;
        @Bind(R.id.listingPostal1TextView) TextView mPostal1TextView;
        private Context mContext;

        public ListingViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindListing(Listing listing) {
            mAddress1TextView.setText(listing.getLine1());
            mAddress2TextView.setText(listing.getLine2());
            mPostal1TextView.setText((int) listing.getPostal1());
            mLocalityTextView.setText(listing.getLocality());
        }
    }
}
