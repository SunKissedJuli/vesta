package com.example.vesta.data.models.info

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class StocksResponse (
    @SerialName("blogarticle_id") val blogArticleId: Int?,
    @SerialName("blogcategory_id") val blogCategoryId: Int?,
    @SerialName("image") val image: String?
)
