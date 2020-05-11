package com.naibeck.testbasiccompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.ConstraintLayout
import androidx.ui.layout.ConstraintSet
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Counter(state = CounterState())
        }
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(onClick = { state.counter++ }) {
        Text(text = "I've been clicked ${state.counter} times")
    }
}

@Model
class CounterState(var counter: Int = 0)

@Preview
@Composable
fun CounterPreview() {
    MaterialTheme {
        Counter(CounterState(counter = 1))
    }
}