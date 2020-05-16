package com.carlospinan.jetpackcomposecookbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.layout.Spacer
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import com.carlospinan.jetpackcomposecookbook.design.SimpleBottomAppBar
import com.carlospinan.jetpackcomposecookbook.design.SimpleBottomAppBarCutoutWithScaffold
import com.carlospinan.jetpackcomposecookbook.design.SimpleTopAppBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // AppBarSample()
                SimpleBottomAppBarCutoutWithScaffold()
            }
        }
    }
}

@Composable
fun AppBarSample() {
    Column {
        SimpleTopAppBar()
        Spacer(Modifier.weight(1f, true))
        SimpleBottomAppBar()
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        AppBarSampleActivity()
    }
}