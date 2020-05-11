package com.carlospinan.composegmail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.carlospinan.composegmail.entity.Email
import com.carlospinan.composegmail.view.EmailList
import com.carlospinan.composegmail.view.EmailNavigationItem
import com.carlospinan.composegmail.view.EmailNavigationItem.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                EmailList(
                    emailList = generateEmailList(),
                    navItems = generateNavigation()
                )
            }
        }
    }
}

fun generateEmailList(): List<Email> {
    val emailList = mutableListOf<Email>()

    (1..100).forEach {
        val date = it % 30
        emailList.add(
            Email(
                sender = "Email Sender $it",
                important = Random.nextBoolean(),
                receiptTime = "April ${date}th",
                subject = "Subject $it - Lorem Ipsum is simply dummy text subject",
                body = "Body $it - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
                starred = Random.nextBoolean()
            )
        )
    }

    return emailList
}

fun generateNavigation(): List<EmailNavigationItem> {
    return listOf(
        AppNameItem,
        DividerItem,
        NavigationDestinationItem(
            "All inbox",
            icon = R.drawable.ic_all_inbox,
            count = null,
            onClick = {}),
        DividerItem,
        NavigationDestinationItem(
            "Inbox",
            icon = R.drawable.ic_inbox,
            count = "2",
            onClick = {}),
        NavigationDestinationItem("Unread", icon = null, count = "4", onClick = {}),
        SectionLabelItem(label = "ALL LABELS"),
        NavigationDestinationItem(
            "Starred",
            icon = R.drawable.ic_star_border,
            count = null,
            onClick = {}),
        NavigationDestinationItem(
            "Snoozed",
            icon = R.drawable.ic_snoozed,
            count = null,
            onClick = {}),
        NavigationDestinationItem(
            "Important",
            icon = R.drawable.ic_important,
            count = null,
            onClick = {}),
        NavigationDestinationItem("Sent", icon = R.drawable.ic_sent, count = null, onClick = {}),
        NavigationDestinationItem(
            "Scheduled",
            icon = R.drawable.ic_scheduled,
            count = null,
            onClick = {}),
        NavigationDestinationItem(
            "Outbox",
            icon = R.drawable.ic_outbox,
            count = null,
            onClick = {}),
        NavigationDestinationItem(
            "Drafts",
            icon = R.drawable.ic_drafts,
            count = null,
            onClick = {}),
        NavigationDestinationItem(
            "All mail",
            icon = R.drawable.ic_all_mail,
            count = null,
            onClick = {}),
        NavigationDestinationItem("Spam", icon = R.drawable.ic_spam, count = "99+", onClick = {}),
        NavigationDestinationItem("Trash", icon = R.drawable.ic_trash, count = "99+", onClick = {}),
        DividerItem,
        NavigationDestinationItem(
            "Settings",
            icon = R.drawable.ic_settings,
            count = null,
            onClick = {}),
        NavigationDestinationItem(
            "Help & feedback",
            icon = R.drawable.ic_help,
            count = null,
            onClick = {})

    )
}