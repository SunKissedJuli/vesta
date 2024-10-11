package com.example.vesta.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun CustomScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    background: Color = MaterialTheme.colorScheme.tertiary,
    content: @Composable () -> Unit,
) {
    val localFocusManager = LocalFocusManager.current

    Column {
        Scaffold(containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            modifier = modifier.weight(1f).pointerInput(Unit) {
                detectTapGestures(onTap = { localFocusManager.clearFocus() })
            },
            topBar = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    topBar?.let { top ->
                        top()
                    }
                }
            },
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(background)
                        .padding(
                            top = it.calculateTopPadding(),
                            bottom = it.calculateBottomPadding()
                        )
                ) {
                    content()
                }
            }
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            bottomBar?.let { bottom ->
                bottom()
            }
        }
    }
}