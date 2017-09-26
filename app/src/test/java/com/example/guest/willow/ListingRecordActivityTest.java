package com.example.guest.willow;

import android.os.Build;
import android.widget.ListView;

import com.example.guest.willow.ui.ListingRecordActivity;

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

public class ListingRecordActivityTest {
    private ListingRecordActivity activity;
    private ListView mPropertyListView;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(ListingRecordActivity.class);
//        mPropertyListView = (ListView) activity.findViewById(R.id.listView);
    }

    @Test
    public void propertyListViewPopulates() {
        assertNotNull(mPropertyListView.getAdapter());
        assertEquals(mPropertyListView.getAdapter().getCount(), 12);
    }
}
