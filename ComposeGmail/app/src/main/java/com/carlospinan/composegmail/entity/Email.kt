package com.carlospinan.composegmail.entity

import androidx.compose.getValue
import androidx.compose.mutableStateOf
import androidx.compose.setValue

/**
 * @author Carlos Piñan
 */
class Email(
    sender: String,
    important: Boolean,
    receiptTime: String,
    subject: String,
    body: String,
    starred: Boolean
) {
    var sender by mutableStateOf(sender)
    var important by mutableStateOf(important)
    var receiptTime by mutableStateOf(receiptTime)
    var subject by mutableStateOf(subject)
    var body by mutableStateOf(body)
    var starred by mutableStateOf(starred)
}