package com.example.guest.willow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class PropertiesActivity extends AppCompatActivity {
    private TextView mLocationTextView;
    private ListView mListView;

    private String[] properties = new String[] {"7322 Blake Pl SW", "722 Nob Hill Ave N # D", "8249 Bagley Ave N", "4324 Greenwood Ave N # A", "725 14th Ave E", "899 NW Elford Dr", "3031 NW 65th St", "808 NW 125th St", "713 Martin Luther King Jr Way S", "459 Newton St", "1020 E Shelby St", "12701 8th Ave NW"};

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

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String property = ((TextView)view).getText().toString();
                Toast.makeText(PropertiesActivity.this, property, Toast.LENGTH_LONG).show();
            }
        });
    }
}
