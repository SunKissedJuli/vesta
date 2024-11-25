package com.example.vesta.data.models.product

import com.example.vesta.data.mapper.product.toUI
import com.example.vesta.data.mapper.toUI
import com.example.vesta.domain.modelsUI.OctStickersUi

fun List<ProductResponse>.toUI(): List<ProductResponseUi> {
    return map { it.toUI() }
}

fun ProductResponse.toUI(): ProductResponseUi {
    return ProductResponseUi(
        attributes = this.attributes?.map { it.toUI() } ?: emptyList(),
        category = this.category?.toUI() ?: CategoryUi.empty,
        dateAdded = this.dateAdded ?: "",
        dateAvailable = this.dateAvailable ?: "",
        dateModified = this.dateModified ?: "",
        description = this.description?.toUI() ?: ProductDescriptionUi.empty,
        ean = this.ean ?: "",
        height = this.height ?: "",
        image = this.image.orEmpty(),
        images = this.images?.map { it.toUI() } ?: emptyList(),
        isbn = this.isbn ?: "",
        jan = this.jan ?: "",
        lastSyncAt = this.lastSyncAt ?: "",
        length = this.length ?: "",
        lengthClassId = this.lengthClassId ?: 0,
        location= this.location ?: "",
        manufacturer= this.manufacturer?.toUI() ?: ManufacturerUi.empty,
        manufacturerId= this.manufacturerId ?: 0,
        minimum= this.minimum ?: 0,
        model= this.model ?: "",
        mpn= this.mpn ?: "",
        multistoreProduct= this.multistoreProduct?.toUI() ?: MultistoreProductUi.empty,
        octStickers= this.octStickers?.toUI() ?: OctStickersUi.empty,
        onesUuid= this.onesUuid ?: "",
        points= this.points ?: 0,
        productId= this.productId ?: 0,
        quantityLen117= this.quantityLen117 ?: 0,
        related= this.related?.map { it.toUI() } ?: emptyList(),
        reviews= this.reviews?.map { it.toUI() } ?: emptyList(),
        shipping= this.shipping ?: 0,
        sku= this.sku ?: "",
        sortOrder= this.sortOrder ?: 0,
        status= this.status ?: 0,
        stockStatusId= this.stockStatusId ?: 0,
        store= this.store?.map { it.toUI() } ?: emptyList(),
        subtract= this.subtract ?: 0,
        taxClassId= this.taxClassId ?: 0,
        upc= this.upc ?: "",
        viewed= this.viewed ?: 0,
        weight= this.weight ?: "",
        weightClassId= this.weightClassId ?: 0,
        width= this.width ?: "",
    )
}

fun MultistoreProduct.toUI(): MultistoreProductUi {
    return MultistoreProductUi(
        dateAdded=this.dateAdded?: "",
        dateModified=this.dateModified?: "",
        id=this.id?: 0,
        lastSyncAt=this.lastSyncAt?: "",
        price=this.price?: 0,
        priceM=this.priceM?: 0,
        priceP=this.priceP?: "",
        pricer=this.pricer?: 0,
        productId=this.productId?: 0,
        quantity=this.quantity?: 0,
        spb1 = this.spb1?:0,
        spb2 = this.spb2?:0,
        spb3 = this.spb3?:0,
        spb4 = this.spb4?:0,
        spb5 = this.spb5?:0,
        spb6 = this.spb6?:0,
        spb7 = this.spb7?:0,
        spb8 = this.spb8?:0,
        spb9 = this.spb9?:0,
        spb10 = this.spb10?:0,
        spb11 = this.spb11?:0,
        spb12 = this.spb12?:0,
        spb13 = this.spb13?:0,
        spb14 = this.spb14?:0,
        spb15 = this.spb15?:0,
        spb16 = this.spb16?:0,
        stockStatusId = this.spb1?:0,
        storeId = this.spb1?:0,
    )
}