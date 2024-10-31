package com.example.vesta.data.mapper.info

import com.example.vesta.data.models.info.Blog
import com.example.vesta.data.models.info.MainBlogObject
import com.example.vesta.data.models.info.MainBlogObjectData
import com.example.vesta.data.models.info.MainBlogResponse
import com.example.vesta.domain.modelsUI.info.BlogUi
import com.example.vesta.domain.modelsUI.info.MainBlogObjectDataUi
import com.example.vesta.domain.modelsUI.info.MainBlogObjectUi
import com.example.vesta.domain.modelsUI.info.MainBlogUi
import com.example.vesta.ext.cleanHtml

fun MainBlogResponse.toUI(): MainBlogUi {
    return MainBlogUi(
        akcii = akcii?.toUI() ?: MainBlogObjectUi.empty,
        akciiSlider = akciiSlider?.toUI() ?: MainBlogObjectUi.empty,
        novinki = novinki?.toUI() ?: MainBlogObjectUi.empty,
        novosti = novosti?.toUI() ?: MainBlogObjectUi.empty
    )
}

fun MainBlogObject.toUI(): MainBlogObjectUi {
    return MainBlogObjectUi(
        name = name.orEmpty(),
        mainBlogObjectData = mainBlogObjectData?.toUI() ?: MainBlogObjectDataUi.empty
    )
}

fun MainBlogObjectData.toUI(): MainBlogObjectDataUi {
    return MainBlogObjectDataUi(
        blogCategories = blogCategories ?: emptyList(),
        blogs = blogs?.map { it.toUI() } ?: emptyList(),
        category = category.orEmpty(),
        height = height.orEmpty(),
        limit = limit.orEmpty(),
        limitDescription = limitDescription.orEmpty(),
        name = name.orEmpty(),
        order = order.orEmpty(),
        sort = sort.orEmpty(),
        status = status.orEmpty(),
        title = title.orEmpty(),
        width = width.orEmpty()
    )
}

fun Blog.toUI(): BlogUi {
    return BlogUi(
        blogarticleDescription = blogarticleDescription?.cleanHtml().orEmpty(),
        blogarticleId = blogarticleId ?: 0,
        blogarticleImage = blogarticleImage.orEmpty(),
        blogarticleName = blogarticleName?.cleanHtml().orEmpty(),
        blogarticleStatus = blogarticleStatus ?: 0,
        blogarticleViewed = blogarticleViewed ?: 0,
        blogcategoryId = blogcategoryId ?: 0,
        blogcategoryMetaTitle = blogcategoryMetaTitle.orEmpty(),
        blogcategoryName = blogcategoryName.orEmpty(),
        dateAdded = dateAdded.orEmpty(),
        storeId = storeId ?: 0
    )
}