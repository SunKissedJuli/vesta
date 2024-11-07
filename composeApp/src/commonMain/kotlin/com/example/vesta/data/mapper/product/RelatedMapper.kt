package com.example.vesta.data.models.product

import com.example.vesta.data.mapper.toUI
import com.example.vesta.data.models.OctStickers
import com.example.vesta.domain.modelsUI.OctStickersUi
import com.example.vesta.ext.cleanHtml
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

fun Related.toUI(): RelatedUi {
    return RelatedUi(
        productId = this.productId ?: 0,
        related = this.related?.toUI() ?: RelatedDetailsUi.empty,
        relatedId = this.relatedId ?: 0,
    )
}

fun RelatedDetails.toUI(): RelatedDetailsUi {
    return RelatedDetailsUi(
        dateAdded = this.dateAdded.orEmpty(),
        dateAvailable = this.dateAvailable.orEmpty(),
        dateModified = this.dateModified.orEmpty(),
        description = this.description?.map { it.toUI() }?: emptyList(),
        ean = this.ean.orEmpty(),
        height = this.height.orEmpty(),
        image = this.image.orEmpty(),
        isbn = this.isbn.orEmpty(),
        jan = this.jan.orEmpty(),
        lastSyncAt= this.lastSyncAt.orEmpty(),
        length= this.length.orEmpty(),
        lengthClassId= this.lengthClassId ?: 0,
        location= this.location.orEmpty(),
        manufacturerId= this.manufacturerId ?: 0,
        minimum= this.minimum ?: 0,
        model= this.model.orEmpty(),
        mpn= this.mpn.orEmpty(),
        octStickers= this.octStickers?.toUI() ?: OctStickersUi.empty,
        onesUuid= this.onesUuid.orEmpty(),
        points= this.points ?: 0,
        productId= this.productId ?: 0,
        quantityLen117= this.quantityLen117 ?: 0,
        shipping= this.shipping ?: 0,
        sku= this.sku.orEmpty(),
        sortOrder= this.sortOrder ?: 0,
        status= this.status ?: 0,
        stockStatusId= this.stockStatusId ?: 0,
        subtract= this.subtract ?: 0,
        taxClassId= this.taxClassId ?: 0,
        upc= this.upc.orEmpty(),
        viewed= this.viewed ?: 0,
        weight= this.weight.orEmpty(),
        weightClassId= this.weightClassId ?: 0,
        width= this.width.orEmpty()
    )
}

fun ProductDescription.toUI(): ProductDescriptionUi {
    return ProductDescriptionUi(
        description=this.description.orEmpty(),
        languageId=this.languageId ?: 0,
        metaDescription=this.metaDescription.orEmpty(),
        metaH1=this.metaH1.orEmpty(),
        metaKeyword=this.metaKeyword.orEmpty(),
        metaTitle=this.metaTitle.orEmpty(),
        name=this.name?.cleanHtml().orEmpty(),
        nameKorr=this.nameKorr?.cleanHtml().orEmpty(),
        productId=this.productId ?: 0,
        tag=this.tag.orEmpty()
    )
}