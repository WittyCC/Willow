package com.example.guest.willow;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mAppNameTextView;
    private Button mSearchPropertiesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface appNameFont = Typeface.createFromAsset(getAssets(), "fonts/CHOPS___.TTF");
        mAppNameTextView.setTypeface(appNameFont);

        mSearchPropertiesButton = (Button) findViewById(R.id.searchPropertiesButton);
            mSearchPropertiesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, PropertiesActivity.class);
                    startActivity(intent);
                    // Toast.makeText(MainActivity.this, "Get this done", Toast.LENGTH_LONG).show();
                }
            });
    }
}
