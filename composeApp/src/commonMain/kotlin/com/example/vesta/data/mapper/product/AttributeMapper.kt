package com.example.vesta.data.models.product

import com.example.vesta.ext.cleanHtml
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


fun Attribute.toUI(): AttributeUi {
    return AttributeUi(
        attribute = this.attribute?.toUI()?: AttributeDetailsUi.empty,
        attributeId = this.attributeId ?: 0,
        languageId = this.languageId ?: 0,
        productId = this.productId ?: 0,
        text = this.text?.cleanHtml().orEmpty(),
    )
}

fun AttributeDetails.toUI(): AttributeDetailsUi {
    return AttributeDetailsUi(
        attributeGroupId = this.attributeGroupId ?: 0,
        attributeId = this.attributeId ?: 0,
        description = this.description?.toUI()?: AttributeDescriptionUi.empty,
        sortOrder = this.sortOrder ?: 0
    )
}

fun AttributeDescription.toUI(): AttributeDescriptionUi {
    return AttributeDescriptionUi(
        attributeId = this.attributeId ?: 0,
        languageId = this.languageId ?: 0,
        name = this.name?.cleanHtml().orEmpty(),
    )
}
