package com.example.vesta.data.api

import com.example.vesta.data.models.CategoryResponse
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST

interface VestaApi {
    //категории
    @GET("api/getAllCategory")
    suspend fun getAllCategory(): Map<String, CategoryResponse>

    @GET("api/getCategoryId/")
    suspend fun getCategoryById(): CategoryResponse

 //   @GET("api/getProductId/")
  //  suspend fun getProductById(): CategoryResponse
}