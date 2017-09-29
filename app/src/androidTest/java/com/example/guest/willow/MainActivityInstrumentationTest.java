package com.example.guest.willow;

import android.support.test.rule.ActivityTestRule;

import com.example.guest.willow.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {
        onView(withId(R.id.userQuery)).perform(typeText("Seattle"))
            .check(matches(withText("Seattle")));
    }

    @Test
    public void locationIsSentToPropertiesActivity() {
        String location = "Seattle";
        onView(withId(R.id.userQuery)).perform(typeText(location));
        onView(withId(R.id.searchPropertiesButton)).perform(click());
//        onView(withId(R.id.locationTextView)).check(matches(withText("Here are the results for your property search in: " + location)));
    }
}
