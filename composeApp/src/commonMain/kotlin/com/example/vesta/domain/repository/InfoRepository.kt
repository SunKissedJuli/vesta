package com.example.vesta.domain.repository

import com.example.vesta.data.models.info.CityUi
import com.example.vesta.domain.modelsUI.blog.BlogByIdUi
import com.example.vesta.domain.modelsUI.info.MainBlogUi
import com.example.vesta.domain.modelsUI.info.NewsUi
import com.example.vesta.domain.modelsUI.info.ShopsUi
import com.example.vesta.domain.modelsUI.info.StocksUi
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure

interface InfoRepository {

    suspend fun getCites() : Either<Failure, List<CityUi>>

    suspend fun getShops() : Either<Failure, List<ShopsUi>>

    suspend fun getStocks() : Either<Failure, List<StocksUi>>

    suspend fun getNews() : Either<Failure, NewsUi>

    suspend fun getMainBlogs() : Either<Failure, MainBlogUi>

    suspend fun getBlogById(id: Int) : Either<Failure, BlogByIdUi>
}