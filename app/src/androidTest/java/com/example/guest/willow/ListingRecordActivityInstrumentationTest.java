package com.example.guest.willow;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.guest.willow.ui.ListingRecordActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.core.IsNot.not;

public class ListingRecordActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<ListingRecordActivity> activityTestRule = new ActivityTestRule<>(ListingRecordActivity.class);

    @Test
    public void listItemClickDisplaysToastWithCorrectProperty() {
        View activityDecorView = activityTestRule.getActivity().getWindow().getDecorView();
        String propertyName = "7322 Blake Pl SW";
//        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withText(propertyName)).inRoot(withDecorView(not(activityDecorView))).check(matches(withText(propertyName)));
    }
}
