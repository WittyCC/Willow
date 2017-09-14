package com.example.guest.willow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class PropertiesActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);

        mLocationTextView = (TextView) findViewById(R.id.locationTextView);
        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are the results for your property search in: " + location);
        mLocationTextView.setGravity(Gravity.CENTER_HORIZONTAL);

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, properties);
        mListView.setAdapter(adapter);
    }
}
