package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName


fun Attribute.toUI(): AttributeUi {
    return AttributeUi(
        attribute = this.attribute?.map { it.toUI() }?: emptyList(),
        attributeId = this.attributeId ?: 0,
        languageId = this.languageId ?: 0,
        productId = this.productId ?: 0,
        text = this.text.orEmpty(),
    )
}

fun AttributeDetails.toUI(): AttributeDetailsUi {
    return AttributeDetailsUi(
        attributeGroupId = this.attributeGroupId ?: 0,
        attributeId = this.attributeId ?: 0,
        description = this.description?.map { it.toUI() }?: emptyList(),
        sortOrder = this.sortOrder ?: 0
    )
}

fun AttributeDescription.toUI(): AttributeDescriptionUi {
    return AttributeDescriptionUi(
        attributeId = this.attributeId ?: 0,
        languageId = this.languageId ?: 0,
        name = this.name.orEmpty(),
    )
}
