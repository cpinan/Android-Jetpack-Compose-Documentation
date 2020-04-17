package com.carlospinan.jetpackcomposelivepreview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

/**
 * @author Carlos Piñan
 * @source https://developer.android.com/jetpack/compose/setup
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialTemplate(colors = darkColorPalette())
        }
    }
}

@Composable
fun TutorialTemplate(
    colors: ColorPalette = lightColorPalette(),
    typography: Typography = Typography()
) {
    val post = Post(
        title = "Dagger in Kotlin: Gotchas and Optimizations",
        author = "Manuel Vivo",
        date = "July 30",
        timeReading = 3,
        resource = R.drawable.preview
    )

    MaterialTheme(
        colors = colors,
        typography = typography
    ) {
        Scaffold(
            topAppBar = {
                TopAppBar(
                    {
                        Text("Tutorial Template")
                    }
                )
            },
            bottomAppBar = {
                BottomAppBar(fabConfiguration = it, cutoutShape = CircleShape) {

                }
            }
        ) {
            Surface {
                PostCard(post)
            }
        }
    }
}

@Composable
fun PostCard(post: Post) {
    val typography = MaterialTheme.typography

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalGravity = Alignment.Start
    ) {

        Image(
            asset = imageResource(id = post.resource),
            modifier = Modifier
                .preferredHeightIn(maxHeight = 180.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(Modifier.preferredHeight(16.dp))

        Text(text = post.title, style = typography.h5)
        Text(text = post.author, style = typography.subtitle1)

        Row {
            Text(
                text = "${post.date} - ${post.timeReading} min read",
                style = typography.subtitle1.copy(
                    color = Color.Gray
                )
            )
        }
    }
}

@Preview("Default Colors")
@Composable
fun TutorialTemplatePreview() {
    TutorialTemplate()
}

@Preview("Dark Colors")
@Composable
fun DarkTutorialTemplatePreview() {
    TutorialTemplate(colors = darkColorPalette())
}

@Preview("Font scaling 1.5, height 300", fontScale = 1.5f, heightDp = 300)
@Composable
fun TutorialTemplateScaledPreview() {
    TutorialTemplate()
}

@Model
data class Post(
    val title: String,
    val author: String,
    val date: String,
    val timeReading: Int,
    val resource: Int
)