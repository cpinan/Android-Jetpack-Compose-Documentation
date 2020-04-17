package com.carlospinan.jetpackcomposebasics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Scaffold
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

/**
 * @author Carlos Piñan
 * @source https://developer.android.com/jetpack/compose/tutorial
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold {
                    NewsStory()
                }
            }
        }
    }
}

@Composable
fun NewsStory() {
    val typography = MaterialTheme.typography
    val image = imageResource(id = R.drawable.header)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        val imageModifier = Modifier
            .preferredHeightIn(maxHeight = 180.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))

        Image(asset = image, modifier = imageModifier, contentScale = ContentScale.FillWidth)

        Spacer(Modifier.preferredHeight(16.dp))

        Text(
            "A day wandering through the sandhills " +
                    "in Shark Fin Cove, and a few of the " +
                    "sights I saw",
            style = typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text("Davenport, California", style = typography.body2)
        Text("December 2018", style = typography.body2)
    }
}

@Preview
@Composable
fun PreviewNewsStory() {
    NewsStory()
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview
@Composable
fun PreviewGreeting() {
    MaterialTheme {
        Greeting("Android")
    }
}