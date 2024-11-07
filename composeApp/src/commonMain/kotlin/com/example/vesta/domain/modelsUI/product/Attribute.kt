package com.example.vesta.data.models.product

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

data class AttributeUi(
    val attribute: AttributeDetailsUi,
    val attributeId: Int,
    val languageId: Int,
    val productId: Int,
    val text: String
) {
    companion object {
        val empty = AttributeUi(
            attribute = AttributeDetailsUi.empty,
            attributeId = 0,
            languageId = 0,
            productId = 0,
            text = ""
        )
    }
}

data class AttributeDetailsUi(
    val attributeGroupId: Int,
    val attributeId: Int,
    val description: AttributeDescriptionUi,
    val sortOrder: Int
) {
    companion object {
        val empty = AttributeDetailsUi(
            attributeGroupId = 0,
            attributeId = 0,
            description = AttributeDescriptionUi.empty,
            sortOrder = 0
        )
    }
}

data class AttributeDescriptionUi(
    val attributeId: Int,
    val languageId: Int,
    val name: String
) {
    companion object {
        val empty = AttributeDescriptionUi(
            attributeId = 0,
            languageId = 0,
            name = ""
        )
    }
}

