package com.example.vesta.data.mapper.info

import com.example.vesta.data.models.info.MainBlogObject
import com.example.vesta.data.models.info.MainBlogObjectData
import com.example.vesta.data.models.info.MainBlogResponse
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
        mainBlogObjectData = mainBlogObjectData?.map{it.toUI() }?: emptyList()
    )
}

fun MainBlogObjectData.toUI(): MainBlogObjectDataUi {
    return MainBlogObjectDataUi(
        blogarticleId = blogarticleId ?: 0,
        blogarticleImage = blogarticleImage.orEmpty(),
        blogarticleName = blogarticleName?.cleanHtml().orEmpty(),
    )
}
