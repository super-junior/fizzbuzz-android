package com.example.fizzbuzz

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fizzbuzz.domain.FizzBuzz
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setUp() {
        launch(MainActivity::class.java)
    }

    @Test
    fun `contain contents`() {
        onView(withId(R.id.input)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.button)).check(matches(withText(R.string.shout_button)))
        onView(withId(R.id.message)).check(matches(withText(R.string.empty_message)))
    }

    @Test
    fun `on click Shout button, show result message`() {
        onView(withId(R.id.input)).perform(click(), replaceText("15"))

        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.message)).check(matches(withText(FizzBuzz.check(15))))
    }

    @Test
    fun `on click Shout button, show empty message if input is empty`() {
        onView(withId(R.id.input)).perform(click(), replaceText(" "))

        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.message)).check(matches(withText(R.string.empty_message)))
    }

}
