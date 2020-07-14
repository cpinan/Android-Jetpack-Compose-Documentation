package com.carlospinan.composegmail.view

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.lazy.LazyColumnItems
import androidx.ui.foundation.selection.toggleable
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.stringResource
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.carlospinan.composegmail.R
import com.carlospinan.composegmail.entity.Email

private const val ICONS_COLOR = 0xFFFDD663

/**
 * @author Carlos Piñan
 * @reference https://www.droidcon.com/media-detail?video=412304809
 */
@Composable
fun EmailItem(email: Email) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        SenderIcon()
        Column(
            modifier = Modifier.padding(start = 8.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
        ) {
            EmailHeader(
                sender = email.sender,
                receiptTime = email.receiptTime,
                important = email.important
            )
            Row(
                verticalGravity = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.weight(1F)
                ) {
                    Subject(subject = email.subject)
                    Body(body = email.body)
                }
                Star(email.starred) { starred ->
                    email.starred = starred
                }
            }
        }
    }
}

@Preview
@Composable
fun EmailItemPreview() {
    val email = Email(
        sender = "Compose Documentation",
        important = true,
        receiptTime = "May 5th",
        subject = "Compose Documentation Updated",
        body = "Here goes the Body",
        starred = true
    )
    EmailItem(email = email)
}

@Composable
fun EmailHeader(
    sender: String,
    receiptTime: String,
    important: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalGravity = Alignment.CenterVertically
    ) {
        if (important) {
            Important()
        }
        Sender(
            sender = sender,
            modifier = Modifier.weight(1F)
        )
        ReceiptTime(receiptTime = receiptTime)
    }
}

@Composable
fun Sender(sender: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = sender,
        style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        ),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun Important() {
    Icon(
        asset = vectorResource(id = R.drawable.ic_important),
        tint = Color(ICONS_COLOR)
        //MaterialTheme.colors.primary
    )
}

@Composable
fun ReceiptTime(receiptTime: String) {
    Text(
        text = receiptTime,
        style = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
        )
    )
}

@Composable
fun Subject(subject: String) {
    Text(
        text = subject,
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp
        ),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun Body(body: String) {
    Text(
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        text = body,
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp
        ),
        softWrap = true
    )
}

@Composable
fun Star(starred: Boolean, onStarClick: (Boolean) -> Unit) {
    val color = if (starred)
        Color(ICONS_COLOR)
    else
        Color.DarkGray

    Icon(
        modifier = Modifier.toggleable(value = starred, onValueChange = onStarClick),
        asset = vectorResource(id = R.drawable.ic_baseline_star_24),
        tint = color
    )
}

@Composable
fun SenderIcon() {
    Box(
        backgroundColor = Color.DarkGray,
        modifier = Modifier
            .clip(CircleShape)
            .preferredSize(36.dp)
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_person),
            tint = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun EmailList(
    emailList: List<Email>,
    navItems: List<EmailNavigationItem>
) {
    val (
        state: ScaffoldState,
        onDrawerStateChange: (ScaffoldState) -> Unit
    ) = state {
        ScaffoldState()
    }

    Scaffold(
        scaffoldState = state,
        topBar = {
            EmailAppbar {
                val newState = if (state.drawerState == DrawerState.Closed) {
                    ScaffoldState(drawerState = DrawerState.Opened)
                } else {
                    ScaffoldState(drawerState = DrawerState.Closed)
                }
                onDrawerStateChange(newState)
            }
        },
        drawerContent = {
            EmailNavigation(navItems = navItems)
        },
        floatingActionButton = {
            NewEmailButton {

            }
        },
        floatingActionButtonPosition = Scaffold.FabPosition.End
    ) {
        LazyColumnItems(items = emailList) { email ->
            EmailItem(email = email)
        }
    }
}

@Composable
fun EmailAppbar(onNavigationClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    asset = vectorResource(id = R.drawable.ic_dashboard_menu)
                )
            }
        }
    )
}

@Composable
fun NewEmailButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_baseline_add_24)
        )
    }
}

@Preview
@Composable
fun NewEmailButtonPreview() {
    NewEmailButton {

    }
}