package com.example.vesta.screen.Info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoDialog(onDismissRequest: ()->Unit){
    AlertDialog(onDismissRequest = {onDismissRequest()}){
       Box( modifier = Modifier
           .height(300.dp)
           .width(300.dp)
           .background(Color.Magenta)){
           Text("мда блин кринж", fontSize = 25.sp)
       }

   }
}
