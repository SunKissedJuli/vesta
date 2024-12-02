package com.example.vesta.data.api

import com.example.vesta.data.models.CategoryByIdResponse
import com.example.vesta.data.models.CategoryResponse
import com.example.vesta.data.models.blog.BlogByIdResponse
import com.example.vesta.data.models.blog.RelatedProduct
import com.example.vesta.data.models.info.CityResponse
import com.example.vesta.data.models.info.MainBlogResponse
import com.example.vesta.data.models.info.NewsResponse
import com.example.vesta.data.models.info.ShopsResponse
import com.example.vesta.data.models.info.StocksResponse
import com.example.vesta.data.models.product.ProductResponse
import com.example.vesta.data.models.user.CurrentUser
import com.example.vesta.data.models.user.NewUser
import com.example.vesta.data.models.user.Token
import com.example.vesta.data.models.user.TokenResponse
import com.example.vesta.data.models.user.UserUpdate
import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.POST
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query

interface VestaApi {

    //категории и продукты
    @GET("api/getCategoryToStore")
    suspend fun getAllCategory(@Query("sity") city: Int = 0): List<CategoryResponse>

    @GET("api/getCategoryId/{categoryId}")
    suspend fun getCategoryById(
        @Path("categoryId") categoryId: Int,
        @Query("limit") limit: Int = 25,
        @Query("page") page: Int = 1,
        @Query("sity") city: Int = 0
    ): CategoryByIdResponse

    @GET("api/getProductId/{productId}")
    suspend fun getProduct(
        @Path("productId") productId: Int,
        @Query("sity") city: Int = 0
    ): ProductResponse

    @GET("api/getModule")
    suspend fun getFeaturedProducts(
        @Query("code") code: String = "featured",
        @Query("sity") city: Int = 0
    ): List<RelatedProduct>

    @POST("api/user/wishlist")
    suspend fun addToWishlist(
        @Query("product_id") productId: Int,
    ): Unit

    //инфо
    @GET("api/info/getSites")
    suspend fun getCites(): List<CityResponse>

    @GET("api/getNews")
    suspend fun getNews(
        @Query("sity") city: Int = 0,
        @Query("limit") limit: Int = 25,
        @Query("page") page: Int = 1
    ): NewsResponse

    @GET("api/info/getShops")
    suspend fun getShops(@Query("sity") city: Int = 0): List<ShopsResponse>

    @GET("api/getMainBlogs")
    suspend fun getMainBlogs(@Query("sity") city: Int = 0): MainBlogResponse

    @GET("api/getStocks") //акции
    suspend fun getStocks(@Query("sity") city: Int = 0): List<StocksResponse>

    @GET("api/getBlogId/{id}")
    suspend fun getBlogById(
        @Path("id") id: Int,
        @Query("sity") city: Int = 0
    ): BlogByIdResponse

    //юзер
    @POST("api/user/login")
    suspend fun authorize(
        @Query("email") login: String,
        @Query("password") password: String
    ): TokenResponse

    @POST("api/user/registration")
    suspend fun registration(@Body user: NewUser): Token

    @GET("api/user/getProfile")
    suspend fun getCurrentUser(): CurrentUser

    @POST("api/user/logout")
    suspend fun logOut(): Unit

    @POST("api/user/getToken")
    suspend fun registrationNullableUser(): TokenResponse

    @POST("api/user/editProfile")
    suspend fun editUser(  @Body user: UserUpdate): Unit

    @GET("api/user/wishlistAll")
    suspend fun getWishlist(): List<RelatedProduct>
}