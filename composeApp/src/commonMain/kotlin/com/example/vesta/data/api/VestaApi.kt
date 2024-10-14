package com.example.vesta.data.api

import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.CategoryResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

interface VestaApi {
    //категории
    @GET("api/getAllCategory")
    suspend fun getAllCategory(): List<CategoryResponse>

    @GET("api/getCategoryId/{categoryId}")
    suspend fun getCategoryById(
        @Path("categoryId") categoryId: Int,
        @Query("limit") limit: Int = 25,
        @Query("page") page: Int = 1
    ): CategoryByIdResponse
}