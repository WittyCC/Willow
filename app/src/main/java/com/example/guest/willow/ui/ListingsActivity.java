package com.example.guest.willow.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.guest.willow.services.OnboardService;
import com.example.guest.willow.R;
import com.example.guest.willow.models.Listing;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ListingsActivity extends AppCompatActivity {

    public static final String TAG = ListingsActivity.class.getSimpleName();

    @Bind(R.id.locationTextView) TextView mLocationTextView;
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Listing> mListings = new ArrayList<>();

    private String[] listings = new String[] {"7322 Blake Pl SW", "722 Nob Hill Ave N # D", "8249 Bagley Ave N", "4324 Greenwood Ave N # A", "725 14th Ave E", "899 NW Elford Dr", "3031 NW 65th St", "808 NW 125th St", "713 Martin Luther King Jr Way S", "459 Newton St", "1020 E Shelby St", "12701 8th Ave NW"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are the results for your property search in: " + location);
        mLocationTextView.setGravity(Gravity.CENTER_HORIZONTAL);

        getListings(location);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listings);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String property = ((TextView)view).getText().toString();
                Toast.makeText(ListingsActivity.this, property, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getListings(String location) {
        final OnboardService onboardService = new OnboardService();
        onboardService.findListings(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mListings = onboardService.processResults(response);

                ListingsActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String [] listingNames = new String[mListings.size()];
                        for (int i = 0; i < listingNames.length; i++) {
                            listingNames[i] = mListings.get(i).getLine1();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ListingsActivity.this, android.R.layout.simple_list_item_1, listingNames);

                        mListView.setAdapter(adapter);

                        for (Listing listing : mListings) {
                            Log.d(TAG, "Address Line 1: " + listing.getLine1());
                            Log.d(TAG, "Address Line 2: " + listing.getLine2());
                            Log.d(TAG, "Locality: " + listing.getLocality());
                            Log.d(TAG, "Postal Code: " + Double.toString(listing.getPostal1()));

                        }
                    }
                });
//                throws
//            } IOException {
//                try {
//                    String jsonData = response.body().string();
//                    if (response.isSuccessful()) {
//                        Log.v(TAG, jsonData);
//                        mListings = onboardService.processResults(response);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}
