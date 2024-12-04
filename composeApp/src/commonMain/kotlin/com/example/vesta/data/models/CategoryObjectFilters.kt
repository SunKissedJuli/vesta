package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CategoryObjectFilters(
    @SerialName("option_id") val optionId: Int?,
    @SerialName("filters_id") val filtersId: List<String>?
)