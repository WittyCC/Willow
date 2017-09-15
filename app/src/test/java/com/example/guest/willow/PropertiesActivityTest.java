package com.example.guest.willow;

import android.os.Build;
import android.widget.ListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class PropertiesActivityTest {
    private PropertiesActivity activity;
    private ListView mPropertyListView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(PropertiesActivity.class);
        mPropertyListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void propertyListViewPopulates() {
        assertNotNull(mPropertyListView.getAdapter());
        assertEquals(mPropertyListView.getAdapter().getCount(), 12);
    }
}
