package com.example.vesta.data.api

import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.CategoryResponse
import com.example.vesta.data.models.ProductsResponse
import com.example.vesta.data.models.info.ShopsResponse
import com.example.vesta.data.models.info.SityResponse
import com.example.vesta.data.models.info.SityUi
import com.example.vesta.data.models.product.ProductResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

interface VestaApi {

    //категории и продукты

    @GET("api/getCategoryToStore")
    suspend fun getAllCategory(@Query("sity") sity: Int = 0): List<CategoryResponse>

   // @GET("api/getAllCategory")
  //  suspend fun getAllCategory(): List<CategoryResponse>

    @GET("api/getCategoryId/{categoryId}")
    suspend fun getCategoryById(
        @Path("categoryId") categoryId: Int,
        @Query("limit") limit: Int = 25,
        @Query("page") page: Int = 1
    ): CategoryByIdResponse

    @GET("api/getProductId/{productId}")
    suspend fun getProduct(@Path("productId") productId: Int,): ProductResponse


    //инфо
    @GET("api/getSites")
    suspend fun getSites(): List<SityResponse>

    @GET("api/getShops")
    suspend fun getShops(@Query("sity") sity: Int = 0): List<ShopsResponse>
}