package com.example.vesta.data.models.info

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
class MainBlogResponse(
    @SerialName("akcii") val akcii: MainBlogObject?,
    @SerialName("akcii_slider") val akciiSlider: MainBlogObject?,
    @SerialName("novinki") val novinki: MainBlogObject?,
    @SerialName("novosti") val novosti: MainBlogObject?
)

@Serializable
class MainBlogObject(
    @SerialName("name") val name: String?,
    @SerialName("setting") val mainBlogObjectData: MainBlogObjectData?
)

@Serializable
class MainBlogObjectData(
    @SerialName("blog_categories") val blogCategories: List<String>?,
    @SerialName("blogs") val blogs: List<Blog>?,
    @SerialName("category") val category: String?,
    @SerialName("height") val height: String?,
    @SerialName("limit") val limit: String?,
    @SerialName("limit_description") val limitDescription: String?,
    @SerialName("name") val name: String?,
    @SerialName("order") val order: String?,
    @SerialName("sort") val sort: String?,
    @SerialName("status") val status: String?,
    @SerialName("title") val title: String?,
    @SerialName("width") val width: String?
)

@Serializable
class Blog(
    @SerialName("blogarticle_description") val blogarticleDescription: String?,
    @SerialName("blogarticle_id") val blogarticleId: Int?,
    @SerialName("blogarticle_image") val blogarticleImage: String?,
    @SerialName("blogarticle_name") val blogarticleName: String?,
    @SerialName("blogarticle_status") val blogarticleStatus: Int?,
    @SerialName("blogarticle_viewed") val blogarticleViewed: Int?,
    @SerialName("blogcategory_id") val blogcategoryId: Int?,
    @SerialName("blogcategory_meta_title") val blogcategoryMetaTitle: String?,
    @SerialName("blogcategory_name") val blogcategoryName: String?,
    @SerialName("date_added") val dateAdded: String?,
    @SerialName("store_id") val storeId: Int?
)