package com.example.tetiana.user_management;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UserListActivityTest {

    @Rule
    public ActivityTestRule<UserListActivity> rule = new ActivityTestRule<>(UserListActivity.class);

    @Test
    public void showTheUsersInTheTable() {
        onView(withText("Tania")).check(matches(isDisplayed()));
        onView(withText("Alice")).check(matches(isDisplayed()));
        onView(withText("Bob")).check(matches(isDisplayed()));
    }
}
