package com.example.vesta.screen.Info

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoDialog(){
   AlertDialog(onDismissRequest = {}){
       Text("мда блин кринж", fontSize = 25.sp)
   }
}

class InfoScreen: Screen{
    @Composable
    override fun Content() {
        InfoDialog()
    }

}