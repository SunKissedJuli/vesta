package com.example.vesta.ext

import androidx.compose.ui.graphics.Color
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.AuthManagerImpl
import com.example.vesta.strings.VestaResourceStrings

fun Int.QuantityToStore(): String {
    val authManager = AuthManagerImpl()
    if(this<=0){
        when (authManager.sity) {
            0 -> return "${VestaResourceStrings.opt_store} ${VestaResourceStrings.spb}"
            1 -> return "${VestaResourceStrings.opt_store} ${VestaResourceStrings.msk}"
            else -> return "${VestaResourceStrings.opt_store} ${VestaResourceStrings.sam}"
        }
    }
    return VestaResourceStrings.store_available
}