package com.example.vesta.data.mapper.info

import com.example.vesta.data.models.info.NewsData
import com.example.vesta.data.models.info.NewsResponse
import com.example.vesta.domain.modelsUI.info.NewsDataUi
import com.example.vesta.domain.modelsUI.info.NewsUi

fun NewsData.toUI(): NewsDataUi {
    return NewsDataUi(
        blogarticleId = blogarticleId ?: 0,
        blogcategoryId = blogcategoryId ?: 0,
        dateAdded = dateAdded.orEmpty(),
        dateAvailable = dateAvailable.orEmpty(),
        dateModified = dateModified.orEmpty(),
        description = description.orEmpty(),
        image = image.orEmpty(),
        languageId = languageId ?: 0,
        metaDescription = metaDescription.orEmpty(),
        metaKeyword = metaKeyword.orEmpty(),
        metaTitle = metaTitle.orEmpty(),
        name = name.orEmpty(),
        shotDescription = shotDescription.orEmpty(),
        sortOrder = sortOrder ?: 0,
        status = status ?: 0,
        storeId = storeId ?: 0,
        tag = tag.orEmpty()
    )
}

fun NewsResponse.toUI(): NewsUi {
    return NewsUi(
        current_page = current_page ?: 0,
        data = data?.map { it.toUI() } ?: emptyList()
    )
}