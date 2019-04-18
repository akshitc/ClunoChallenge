package com.akshit.clunochallenge.list

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import com.akshit.clunochallenge.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ClunoListActivityTest {

    @get:Rule
    val intentsTestRule = IntentsTestRule(ClunoListActivity::class.java)

    @Test
    fun testListItemData() {
        Thread.sleep(1000)
        checkItemAtPositionWithText(0, "Opel")
        checkItemAtPositionWithText(0, "Corsa")
        checkItemAtPositionWithText(0, "259€")
    }

    @Test
    fun testCarDetail() {
        Thread.sleep(1000)
        onView(RecyclerViewMatcher(R.id.recyclerView).atPosition(0))
            .perform(click())
        onView(withText("Opel Corsa EDITION")).check(matches(isDisplayed()))
    }

    private fun checkItemAtPositionWithText(position: Int, text: String) {
        onView(RecyclerViewMatcher(R.id.recyclerView).atPosition(position))
            .check(matches(hasDescendant(withText(text))))
    }
}