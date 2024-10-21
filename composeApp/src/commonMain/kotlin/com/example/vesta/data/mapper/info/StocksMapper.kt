package com.example.vesta.data.mapper.info

import com.example.vesta.data.models.info.SityResponse
import com.example.vesta.data.models.info.SityUi
import com.example.vesta.data.models.info.StocksResponse
import com.example.vesta.domain.modelsUI.info.StocksUi

fun StocksResponse.toUI(): StocksUi {
    return StocksUi(
        blogArticleId = blogArticleId?:0,
        blogCategoryId = blogCategoryId?:0,
        image = image.orEmpty()
    )
}

fun List<StocksResponse>.toUI(): List<StocksUi> {
    return map { it.toUI() }
}
