package com.example.tetiana.user_management;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UserListActivityTest {

    @Rule
    public ActivityTestRule<UserListActivity> rule = new ActivityTestRule<>(UserListActivity.class);

    @Test
    public void showTheUsersInTheTable() {
        onView(withText("Mark")).check(matches(isDisplayed()));
        onView(withText("John")).check(matches(isDisplayed()));
        onView(withText("Anna")).check(matches(isDisplayed()));
    }

    @Test
    public void showTheUsersDetail() {
        onView(withText("John")).perform(click());
        onView(withId(R.id.user_detailed_name)).check(matches(withText("John")));
        onView(withId(R.id.user_detailed_email)).check(matches(withText("john@gmail.com")));
        onView(withId(R.id.user_detailed_age)).check(matches(withText("34")));
        onView(withId(R.id.user_detailed_is_female)).check(matches(withText("Male")));
        onView(withText("Swimming")).check(matches(isDisplayed()));
        onView(withText("Driving")).check(matches(isDisplayed()));
        onView(withText("Singing")).check(matches(isDisplayed()));
        onView(withText("Playing piano")).check(matches(isDisplayed()));
        onView(withText("making funny noises")).check(matches(isDisplayed()));
    }

    @Test
    public void showTheUsersIsFemale() {
        onView(withText("Anna")).perform(click());
        onView(withId(R.id.user_detailed_is_female)).check(matches(withText("Female")));
    }

}
