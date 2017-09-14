package com.example.guest.willow;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface appNameFont = Typeface.createFromAsset(getAssets(), "fonts/CHOPS___.TTF");
        mAppNameTextView.setTypeface(appNameFont);
    }
}
