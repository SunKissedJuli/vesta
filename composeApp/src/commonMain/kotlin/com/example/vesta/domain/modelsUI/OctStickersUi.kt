package com.example.vesta.domain.modelsUI

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class OctStickerDataUi(
    val fonColor: String,
    val sort: String,
    val textColor: String,
    val title: String
){
    companion object{
        val empty = OctStickerDataUi(
            fonColor = "",
            sort = "",
            textColor = "",
            title = ""
        )
    }
}

data class OctStickersUi(
    val stickerData: OctStickerDataUi,
    val specialStickerData: SpecialStickerDataUi
){
    companion object{
        val empty = OctStickersUi(
            stickerData = OctStickerDataUi.empty,
            specialStickerData = SpecialStickerDataUi.empty
        )
    }
}

data class SpecialStickerDataUi(
    val fonColor: String,
    val viewTitle: String,
    val sort: String,
    val textColor: String,
    val title: String
){
    companion object{
        val empty = SpecialStickerDataUi(
            fonColor = "",
            viewTitle = "",
            sort = "",
            textColor = "",
            title = ""
        )
    }
}

