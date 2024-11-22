package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CategoryByIdResponse(
    @SerialName("category") val category: CategoryById?,
    @SerialName("products") val products: List<ProductInCategoryResponse>?,
)

@Serializable
class CategoryById(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("children") val children: List<CategoryById>?,
 //   @SerialName("column") val column: Int?,
 //   @SerialName("description") val description: DescriptionResponse?,
    @SerialName("image") val image: String?,
    @SerialName("name") val name: String?,
  //  @SerialName("oct_image") val octImage: String?,
   // @SerialName("parent_id") val parentId: Int?,
  //  @SerialName("sort_order") val sortOrder: Int?,
 //   @SerialName("status") val status: Int?,
  //  @SerialName("top") val top: Int?
)

@Serializable
class ProductInCategoryResponse(
    @SerialName("category_id") val categoryId: Int?,
 //   @SerialName("description") val description: String?,
    @SerialName("image") val image: String?,
//    @SerialName("isbn") val isbn: String?,
    @SerialName("manufacturer_id") val manufacturerId: Int?,
    @SerialName("manufacturer_name") val manufacturerName: String?,
    //   @SerialName("meta_keyword") val metaKeyword: String?,
    //   @SerialName("meta_title") val metaTitle: String?,
//    @SerialName("model") val model: String?,
//    @SerialName("name") val name: String?,
    @SerialName("name_korr") val nameKorr: String?,
    @SerialName("oct_stickers") val octStickers: OctStickers?,
    @SerialName("price") val price: Int?,
    //  @SerialName("pricep") val pricep: String?,
    @SerialName("product_id") val productId: Int?,
    @SerialName("quantity") val quantity: Int?,
    //  @SerialName("status") val status: Int?,
    //   @SerialName("stock_status_id") val stockStatusId: Int?,
    //   @SerialName("store_id") val storeId: Int?,
//    @SerialName("tag") val tag: String?,
    @SerialName("quantity_status") val quantityStatus: String?
)

@Serializable
class Link(
    @SerialName("active") val active: Boolean?,
    @SerialName("label") val label: String?,
    @SerialName("url") val url: String?
)

