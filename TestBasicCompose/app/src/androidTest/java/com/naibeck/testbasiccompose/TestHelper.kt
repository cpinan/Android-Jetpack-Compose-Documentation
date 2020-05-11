package com.naibeck.testbasiccompose

import androidx.compose.Composable
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import androidx.ui.test.ComposeTestRule

fun ComposeTestRule.launchCounterApp() {
    setContent {
        Counter(state = CounterState())
    }
}

fun CounterState.resetState() {
    counter = 0
}

/**
 * Helper method that can be used to test Jetnews UI Composables in isolation
 */
fun ComposeTestRule.setMaterialContent(children: @Composable() () -> Unit) {
    setContent {
        MaterialTheme {
            Surface {
                children()
            }
        }
    }
}


