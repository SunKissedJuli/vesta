package com.example.vesta.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CategoryResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("image") val image: String?,
    @SerialName("oct_image") val octImage: String?,
    @SerialName("parent_id") val parentId: Int?,
    @SerialName("top") val top: Int?,
    @SerialName("column") val column: Int?,
    @SerialName("sort_order") val sortOrder: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("page_group_links") val pageGroupLinks: String?,
    @SerialName("date_added") val dateAdded: String?,
    @SerialName("date_modified") val dateModified: String?,
    @SerialName("last_sync_at") val lastSyncAt: String?,
    @SerialName("ones_uuid") val onesUuid: String?,
    @SerialName("description") val description: List<DescriptionResponse>?,
    @SerialName("category") val category: List<SubCategoryResponse>?
)

@Serializable
class DescriptionResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("language_id") val languageId: Int?,
    @SerialName("name") val name: String?,
    @SerialName("description") val description: String?,
    @SerialName("meta_title") val metaTitle: String?,
    @SerialName("meta_h1") val metaH1: String?,
    @SerialName("meta_description") val metaDescription: String?,
    @SerialName("meta_keyword") val metaKeyword: String?
)

@Serializable
class SubCategoryResponse(
    @SerialName("category_id") val categoryId: Int?,
    @SerialName("image") val image: String?,
    @SerialName("oct_image") val octImage: String?,
    @SerialName("parent_id") val parentId: Int?,
    @SerialName("top") val top: Int?,
    @SerialName("column") val column: Int?,
    @SerialName("sort_order") val sortOrder: Int?,
    @SerialName("status") val status: Int?,
    @SerialName("page_group_links") val pageGroupLinks: String?,
    @SerialName("date_added") val dateAdded: String?,
    @SerialName("date_modified") val dateModified: String?,
    @SerialName("last_sync_at") val lastSyncAt: String?,
    @SerialName("ones_uuid") val onesUuid: String?,
    @SerialName("description") val description: List<DescriptionResponse>?
)