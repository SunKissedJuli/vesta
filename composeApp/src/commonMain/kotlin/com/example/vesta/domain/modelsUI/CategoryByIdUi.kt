package com.example.vesta.domain.modelsUI

import com.example.vesta.data.models.CategoryById
import com.example.vesta.data.models.OctStickers
import com.example.vesta.data.models.ProductsDataResponse
import com.example.vesta.data.models.ProductsResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


class CategoryByIdResponseUi(
    val category: CategoryByIdUi,
    val products: List<ProductInCategoryUi>,
)

data class CategoryByIdUi(
    val categoryId: Int,
    val children: List<CategoryByIdUi>,
  //  val column: Int,
   // val description: DescriptionUi,
    val image: String,
    val name: String
   // val octImage: String,
  //  val parentId: Int,
  //  val sortOrder: Int,
  //  val status: Int,
  //  val top: Int
){
    companion object{
        val empty = CategoryByIdUi(
            categoryId = 0,
            children = emptyList(),
          //  column = 0,
        //    description = DescriptionUi.empty,
            image = "",
            name = ""
         //   octImage = "",
          //  parentId = 0,
          //  sortOrder = 0,
          //  status = 0,
          //  top = 0
        )
    }
}

data class ProductInCategoryUi(
    val categoryId: Int?,
    val image: String,
    val manufacturerId: Int,
    val manufacturerName: String,
    val nameKorr: String,
    val octStickers: OctStickersUi,
    val price: Int,
    val productId: Int,
    val quantity: Int,
    val quantityStatus: String
)

data class LinkUi(
    val active: Boolean,
    val label: String,
    val url: String
)
