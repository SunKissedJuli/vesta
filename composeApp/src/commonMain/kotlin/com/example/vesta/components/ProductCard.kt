package com.example.vesta.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vesta.domain.modelsUI.ProductDataResponseUi

@Composable
fun ProductCard(product: ProductDataResponseUi){

    Surface(
        Modifier
            .fillMaxWidth()
            .height(230.dp)
            .padding(horizontal = 20.dp, vertical = 7.dp)
            //  .border(1.dp, MaterialTheme.colorScheme.onSecondaryContainer)
        ,
        shadowElevation = 5.dp) {

        Column(Modifier.fillMaxSize()) {
            Row(Modifier.fillMaxWidth()){

            }

            Row(Modifier.fillMaxWidth().padding(10.dp)){
                CustomAsyncImage(product.image, modifier = Modifier.weight(1.25f) )
                Spacer(Modifier.width(10.dp))
                Text(text = product.nameKorr, fontSize = 16.sp, softWrap = true, modifier = Modifier.weight(2f))
            }


        }
    }
}