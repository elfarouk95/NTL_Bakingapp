package com.example.elfaroukomar.ntl_bakingaopp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Elfarouk Omar on 20/10/2017.
 */
@RunWith(AndroidJUnit4.class)
public class StepTest {
    @Rule
  public   ActivityTestRule<MainActivity> mainActivityActivityTestRule =new ActivityTestRule<MainActivity>(MainActivity.class);


    @Test
    public  void RVtestclick()
    {

        onView((withId(R.id.Rvrecap))).perform(click()).check(matches(isDisplayed()));



    }
}
