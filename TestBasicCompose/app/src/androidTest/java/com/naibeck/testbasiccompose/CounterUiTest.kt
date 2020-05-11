package com.naibeck.testbasiccompose

import androidx.test.filters.MediumTest
import androidx.ui.test.assertIsDisplayed
import androidx.ui.test.createComposeRule
import androidx.ui.test.doClick
import androidx.ui.test.findByText
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@MediumTest
@RunWith(JUnit4::class)
class CounterUiTest {

    @get:Rule
    val composableTestRule = createComposeRule()

    @Before
    fun setup() {
        composableTestRule.launchCounterApp()
    }

    @Test
    fun app_launches() {
        findByText("I've been clicked 0 times", ignoreCase = true)
    }

    @Test
    fun counter_click_update() {
        findByText("I've been clicked 0 times").doClick()
        findByText("I've been clicked 1 times").assertIsDisplayed()
    }
}