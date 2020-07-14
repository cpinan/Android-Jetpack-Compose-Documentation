package com.naibeck.testbasiccompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Counter(CounterState())
        }
    }
}

@Composable
fun Counter(counter: CounterState) {
    var counterState by state { counter }
    Button(onClick = {
        counterState = counterState.copy(
            counter = counterState.counter + 1
        )
    }) {
        Text(text = "I've been clicked ${counterState.counter} times")
    }
}

data class CounterState(var counter: Int = 0)

@Preview
@Composable
fun CounterPreview() {
    MaterialTheme {
        Counter(CounterState(counter = 1))
    }
}