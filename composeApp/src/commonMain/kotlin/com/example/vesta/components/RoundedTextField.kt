package com.example.vesta.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.sp

@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    errorMessage: String = "",
    modifier: Modifier = Modifier
) {
    val isPlaceholderVisible = value.isEmpty()
    val interactionSource = remember { MutableInteractionSource() }
    val labelFontSize by animateFloatAsState(targetValue = if (isPlaceholderVisible) 16f else 12f)
    val labelColor = if (errorMessage.isNotEmpty()) MaterialTheme.colorScheme.onTertiary else MaterialTheme.colorScheme.secondaryContainer

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        maxLines = 1,
        onValueChange = {
            onValueChange(it)
        },
        shape = RoundedCornerShape(50.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.background,
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
            focusedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondaryContainer,
            unfocusedTextColor = MaterialTheme.colorScheme.onSecondary,
            focusedTextColor = MaterialTheme.colorScheme.onSecondary,
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.secondaryContainer,
            focusedPlaceholderColor = MaterialTheme.colorScheme.secondaryContainer,
            disabledPlaceholderColor = MaterialTheme.colorScheme.secondaryContainer,
            errorPlaceholderColor = MaterialTheme.colorScheme.onTertiary,
            errorTextColor =  MaterialTheme.colorScheme.onTertiary,
            errorBorderColor =  MaterialTheme.colorScheme.onTertiary,
            errorContainerColor = MaterialTheme.colorScheme.background
        ),
        isError = errorMessage.isNotEmpty(),
        label = {
            Text(
                text = errorMessage.ifEmpty { placeholder },
                color = labelColor,
                fontSize = labelFontSize.sp
            )
        },
        interactionSource = interactionSource,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}