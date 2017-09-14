package com.example.guest.willow;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // public static final String TAG = MainActivity.class.getSimpleName();
    private TextView mAppNameTextView;
    private EditText mUserQuery;
    private Button mSearchPropertiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface appNameFont = Typeface.createFromAsset(getAssets(), "fonts/CHOPS___.TTF");
        mAppNameTextView.setTypeface(appNameFont);

        mUserQuery = (EditText) findViewById(R.id.userQuery);

        mSearchPropertiesButton = (Button) findViewById(R.id.searchPropertiesButton);
            mSearchPropertiesButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    String location = mUserQuery.getText().toString();
                    // Log.d(TAG, location);
                    Intent intent = new Intent(MainActivity.this, PropertiesActivity.class);
                    intent.putExtra("location", location);
                    startActivity(intent);
                    // Toast.makeText(MainActivity.this, "Get this done", Toast.LENGTH_LONG).show();
                }
            });
    }
}
