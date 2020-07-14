package com.carlospinan.jetpackcomposecookbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.getValue
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import com.carlospinan.jetpackcomposecookbook.design.SimpleBottomAppBar
import com.carlospinan.jetpackcomposecookbook.design.SimpleBottomAppBarCutoutWithScaffold
import com.carlospinan.jetpackcomposecookbook.design.SimpleTopAppBar

/**
 * @author Carlos Piñan
 */
class AppBarSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val currentBarStyle by state { AppBarStyle() }
            MaterialTheme {
                Column {
                    Button(
                        onClick = { currentBarStyle.next() },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Try next design")
                    }
                    when (currentBarStyle.type) {
                        1 -> SimpleTopAppBar()
                        2 -> SimpleBottomAppBar()
                        else -> SimpleBottomAppBarCutoutWithScaffold()
                    }
                }
            }
        }
    }

    data class AppBarStyle(var type: Int = 0) {
        fun next() {
            type++
            type %= 3
        }
    }

}