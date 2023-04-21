package com.bekiarispanagiotis.androidtuner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.bekiarispanagiotis.androidtuner", appContext.getPackageName());
    }
    @Test
    public void launchActivity() {
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        assertEquals(activityScenario.getState(), Lifecycle.State.RESUMED); //  The activity became active and ready to receive input
        activityScenario.close();
    }
    @Test
    public void graphics(){
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        onView(withId(R.id.textApp)).check(matches(isDisplayed()));
        onView(withId(R.id.noteText)).check(matches(isDisplayed()));
        onView(withId(R.id.pitchText)).check(matches(isDisplayed()));
        onView(withId(R.id.imageGuitar)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViolin)).check(matches(isDisplayed()));
        activityScenario.close();
    }
    @Test
    public void infoClick() {
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        onView(withId(R.id.button)).perform(click()); //Show info Dialog
        activityScenario.close();
    }
    @Test
    public void switchInstrumentClick() {
        var activityScenario = ActivityScenario.launchActivityForResult(MainActivity.class);
        onView(withId(R.id.switchInstrument)).perform(click()); //Show Violin after click
        onView(withId(R.id.switchInstrument)).perform(click()); //Return to Guitar after click
        activityScenario.close();
    }
}