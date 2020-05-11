package com.carlospinan.composegmail.entity

import androidx.compose.Model

/**
 * @author Carlos Piñan
 */
@Model
data class Email(
    val sender: String,
    val important: Boolean,
    val receiptTime: String,
    val subject: String,
    val body: String,
    var starred: Boolean
)