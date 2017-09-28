package com.example.guest.willow.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guest.willow.Constants;
import com.example.guest.willow.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    // public static final String TAG = MainActivity.class.getSimpleName();
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;
    @Bind (R.id.userQuery) EditText mUserQuery;
    @Bind(R.id.searchPropertiesButton) Button mSearchPropertiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mEditor = mSharedPreferences.edit();

        Typeface appNameFont = Typeface.createFromAsset(getAssets(), "fonts/CHOPS___.TTF");
        mAppNameTextView.setTypeface(appNameFont);

        mSearchPropertiesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSearchPropertiesButton) {
            String location = mUserQuery.getText().toString();
            if(!(location).equals("")) {
                addToSharedPreferences(location);
            }

//        } else {
//
//        if(mUserQuery.getText().toString().length() == 0) {
//                    mUserQuery.setError("Please enter a location");
//        } else {
//                    Log.d(TAG, location);
            Intent intent = new Intent(MainActivity.this, ListingRecordActivity.class);
//                    intent.putExtra("location", location);
            startActivity(intent);
        }
            // Toast.makeText(MainActivity.this, "Get this done", Toast.LENGTH_LONG).show();
    }

    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
    }
}


