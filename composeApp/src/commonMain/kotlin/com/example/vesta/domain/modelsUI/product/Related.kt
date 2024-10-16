package com.example.vesta.data.models.product

import com.example.vesta.data.models.OctStickers
import com.example.vesta.domain.modelsUI.OctStickersUi
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

data class RelatedUi(
    val productId: Int,
    val related: RelatedDetailsUi,
    val relatedId: Int
) {
    companion object {
        val empty = RelatedUi(
            productId = 0,
            related = RelatedDetailsUi.empty,
            relatedId = 0
        )
    }
}

data class RelatedDetailsUi(
    val dateAdded: String,
    val dateAvailable: String,
    val dateModified: String,
    val description: List<ProductDescriptionUi>,
    val ean: String,
    val height: String,
    val image: String,
    val isbn: String,
    val jan: String,
    val lastSyncAt: String,
    val length: String,
    val lengthClassId: Int,
    val location: String,
    val manufacturerId: Int,
    val minimum: Int,
    val model: String,
    val mpn: String,
    val octStickers: OctStickersUi,
    val onesUuid: String,
    val points: Int,
    val productId: Int,
    val quantityLen117: Int,
    val shipping: Int,
    val sku: String,
    val sortOrder: Int,
    val status: Int,
    val stockStatusId: Int,
    val subtract: Int,
    val taxClassId: Int,
    val upc: String,
    val viewed: Int,
    val weight: String,
    val weightClassId: Int,
    val width: String
) {
    companion object {
        val empty =  RelatedDetailsUi (
            dateAdded = "",
            dateAvailable = "",
            dateModified = "",
            description = emptyList(),
            ean = "",
            height = "",
            image = "",
            isbn = "",
            jan = "",
            lastSyncAt = "",
            length = "",
            lengthClassId = 0,
            location = "",
            manufacturerId = 0,
            minimum = 0,
            model = "",
            mpn = "",
            octStickers = OctStickersUi.empty,
            onesUuid = "",
            points = 0,
            productId = 0,
            quantityLen117 = 0,
            shipping = 0,
            sku = "",
            sortOrder = 0,
            status = 0,
            stockStatusId = 0,
            subtract = 0,
            taxClassId = 0,
            upc = "",
            viewed = 0,
            weight = "",
            weightClassId = 0,
            width = ""
        )

    }
}

data class ProductDescriptionUi(
    val description: String,
    val languageId: Int,
    val metaDescription: String,
    val metaH1: String,
    val metaKeyword: String,
    val metaTitle: String,
    val name: String,
    val nameKorr: String,
    val productId: Int,
    val tag: String
) {
    companion object {
        val empty = ProductDescriptionUi(
            description = "",
            languageId = 0,
            metaDescription= "",
            metaH1= "",
            metaKeyword= "",
            metaTitle= "",
            name= "",
            nameKorr= "",
            productId= 0,
            tag= ""
        )

    }
}