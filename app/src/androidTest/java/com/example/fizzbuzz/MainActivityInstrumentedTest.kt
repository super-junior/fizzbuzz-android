package com.example.fizzbuzz

import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Before
import org.junit.Test

class MainActivityInstrumentedTest {

    @Before
    fun setUp() {
        launch(MainActivity::class.java)
    }

    @Test
    fun containContents() {
        Espresso.onView(ViewMatchers.withId(R.id.input))
            .check(ViewAssertions.matches(ViewMatchers.isCompletelyDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.button))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.shout_button)))
        Espresso.onView(ViewMatchers.withId(R.id.message))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.empty_message)))
    }

    @Test
    fun onClickShoutButton_showResultMessage() {
        Espresso.onView(ViewMatchers.withId(R.id.input))
            .perform(ViewActions.click(), ViewActions.replaceText("15"))

        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.message))
            .check(ViewAssertions.matches(ViewMatchers.withText(FizzBuzz.check(15))))
    }

    @Test
    fun onClickShoutButton_showEmptyMessage_ifInputIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.input))
            .perform(ViewActions.click(), ViewActions.replaceText(" "))

        Espresso.onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.message))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.empty_message)))
    }

}