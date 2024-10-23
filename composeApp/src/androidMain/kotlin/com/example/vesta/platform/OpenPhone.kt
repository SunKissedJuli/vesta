package com.example.vesta.platform

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.russhwolf.settings.Settings
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent.inject

@Composable
actual fun OpenPhone(phone: String){
    val context = LocalContext.current
    val intent = Intent(Intent.ACTION_DIAL).apply {
        data = Uri.parse("tel:$phone")
    }
    context.startActivity(intent)
}