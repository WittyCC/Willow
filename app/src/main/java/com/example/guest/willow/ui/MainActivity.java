package com.example.guest.willow.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedLocationReference;

    private ValueEventListener mSearchedLocationReferenceListener;

    // public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind (R.id.userQuery) EditText mUserQuery;
    @Bind(R.id.searchPropertiesButton) Button mSearchPropertiesButton;
    @Bind(R.id.saveListingButton) Button mSavedListingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);

        // Attach listener
        mSearchedLocationReferenceListener = mSearchedLocationReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                    String location = locationSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + location);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//
//        mEditor = mSharedPreferences.edit();

        Typeface appNameFont = Typeface.createFromAsset(getAssets(), "fonts/CHOPS___.TTF");
        mAppNameTextView.setTypeface(appNameFont);

        mSearchPropertiesButton.setOnClickListener(this);
        mSavedListingsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchPropertiesButton) {
            String location = mUserQuery.getText().toString();

            saveLocationToFirebase(location);

//            if(!(location).equals("")) {
//                addToSharedPreferences(location);
//            }

//        } else {
//
//        if(mUserQuery.getText().toString().length() == 0) {
//                    mUserQuery.setError("Please enter a location");
//        } else {
//                    Log.d(TAG, location);
            Intent intent = new Intent(MainActivity.this, ListingRecordActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
            // Toast.makeText(MainActivity.this, "Get this done", Toast.LENGTH_LONG).show();

        if (v == mSavedListingsButton) {
            Intent intent = new Intent(MainActivity.this, SavedListingRecordActivity.class);
            startActivity(intent);
        }
    }

    public void saveLocationToFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedLocationReference.removeEventListener(mSearchedLocationReferenceListener);
    }

//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }
}


