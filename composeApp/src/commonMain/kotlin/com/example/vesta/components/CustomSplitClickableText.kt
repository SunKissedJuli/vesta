package com.example.vesta.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun CustomSplitClickableText(
    text: String,
    onClick: () -> Unit,
    wordCount: Int = 1,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center
) {
    val words = text.split(" ")
    val lastWord = words.takeLast(wordCount).joinToString(" ")
    val mainText = words.dropLast(wordCount).joinToString(" ")

    val annotatedString = buildAnnotatedString {
        append(mainText)
        if (mainText.isNotEmpty()) append(" ")
        withStyle(style = SpanStyle(
            color = MaterialTheme.colorScheme.primary,
            textDecoration = TextDecoration.Underline)
        ) {
            append(lastWord)
        }
    }

    Text(
        text = annotatedString,
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.onSecondary,
        textAlign = textAlign,
        letterSpacing = 0.5.sp,
        lineHeight = 14.63.sp,
        modifier = modifier.clickable { onClick() }
    )
}