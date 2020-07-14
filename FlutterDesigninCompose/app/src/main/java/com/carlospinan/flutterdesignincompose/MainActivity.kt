package com.carlospinan.flutterdesignincompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.getValue
import androidx.compose.setValue
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.res.stringResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextAlign
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dashboard()
        }
    }
}

@Composable
fun Dashboard() {
    MaterialTheme(
        colors = lightColorPalette()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth()
                ) {
                }
            }
        ) {
            Surface {
                VerticalScroller {
                    Column {
                        ImageSection()
                        TitleSection()
                        ButtonsSection()
                        DescriptionSection()
                    }
                }
            }
        }
    }
}

@Composable
fun ImageSection() {
    Image(
        contentScale = ContentScale.FillWidth,
        asset = imageResource(id = R.drawable.lake),
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeight(280.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun TitleSection() {
    var action by state { StarAction() }
    Box(
        modifier = Modifier.padding(32.dp)
    ) {
        Row(
            verticalGravity = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(0.75F, true)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(id = R.string.title),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = stringResource(id = R.string.sub_title),
                    style = TextStyle(
                        color = Color.Gray
                    )
                )
            }
            Row(
                modifier = Modifier.clickable(
                    onClick =
                    {
                        action = action.copy(
                            enabled = !action.enabled
                        )
                    }
                ),
                verticalGravity = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.width(32.dp)
                        .height(32.dp),
                    asset = imageResource(
                        id = if (action.enabled) android.R.drawable.star_on else android.R.drawable.star_off
                    ),
                    tint = if (action.enabled) Color.Red else Color.Gray
                )
                Text(
                    text = "41",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ButtonsSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        ActionButton(
            title = stringResource(id = R.string.call),
            resource = android.R.drawable.ic_menu_call
        )
        ActionButton(
            title = stringResource(id = R.string.route),
            resource = android.R.drawable.ic_menu_mapmode
        )
        ActionButton(
            title = stringResource(id = R.string.share),
            resource = android.R.drawable.ic_menu_share
        )
    }
}

@Composable
fun ActionButton(title: String, resource: Int) {
    Column(
        modifier = Modifier.clickable(
            onClick = {
                println("$title - $resource")
            }
        ),
        horizontalGravity = Alignment.CenterHorizontally
    ) {
        Icon(
            asset = imageResource(id = resource),
            tint = MaterialTheme.colors.primary
        )
        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = title.toUpperCase(Locale.getDefault()),
            style = TextStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400
            )
        )
    }
}

@Composable
fun DescriptionSection() {
    Text(
        modifier = Modifier.padding(32.dp),
        text = stringResource(id = R.string.description),
        softWrap = true,
        style = TextStyle(
            textAlign = TextAlign.Justify
        )
    )
}

data class StarAction(var enabled: Boolean = false)