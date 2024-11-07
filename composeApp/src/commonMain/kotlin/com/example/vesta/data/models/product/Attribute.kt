package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class Attribute(
    @SerialName("attribute") val attribute: AttributeDetails?,
    @SerialName("attribute_id") val attributeId: Int?,
    @SerialName("language_id") val languageId: Int?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("text") val text: String?
)

@Serializable
class AttributeDetails(
    @SerialName("attribute_group_id") val attributeGroupId: Int?,
    @SerialName("attribute_id") val attributeId: Int?,
    @SerialName("description") val description:AttributeDescription?,
    @SerialName("sort_order") val sortOrder: Int?
)

@Serializable
class AttributeDescription(
    @SerialName("attribute_id") val attributeId: Int?,
    @SerialName("language_id") val languageId: Int?,
    @SerialName("name") val name: String?
)
