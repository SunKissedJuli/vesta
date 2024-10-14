package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class OctStickers(
    @SerialName("customer") val stickerData: OctStickerData?,
    @SerialName("stickers_special") val specialStickerData: SpecialStickerData?
)

@Serializable
class OctStickerData(
    @SerialName("fon_color") val fonColor: String?,
 //   @SerialName("link") val link: String?,
    @SerialName("sort") val sort: String?,
    @SerialName("text_color") val textColor: String?,
    @SerialName("title") val title: String?
)

@Serializable
class SpecialStickerData(
    @SerialName("fon_color") val fonColor: String?,
    @SerialName("view_title") val viewTitle: String?,
    @SerialName("sort") val sort: String?,
    @SerialName("text_color") val textColor: String?,
    @SerialName("title") val title: String?
)

