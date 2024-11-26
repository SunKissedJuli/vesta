package com.example.vesta.data.repositoryImpl

import com.example.vesta.data.api.VestaApi
import com.example.vesta.data.mapper.blog.toUI
import com.example.vesta.data.mapper.info.toUI
import com.example.vesta.data.models.info.CityUi
import com.example.vesta.data.models.info.toUI
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.modelsUI.blog.BlogByIdUi
import com.example.vesta.domain.modelsUI.info.MainBlogUi
import com.example.vesta.domain.modelsUI.info.NewsUi
import com.example.vesta.domain.modelsUI.info.ShopsUi
import com.example.vesta.domain.modelsUI.info.StocksUi
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.platform.apiCall

class InfoRepositoryImpl(private val vestaApi: VestaApi, private val manager: AuthManager) : InfoRepository {
    override suspend fun getCites(): Either<Failure, List<CityUi>> {
        return apiCall (call = {
            vestaApi.getCites()
        },
            mapResponse = { city -> city.toUI() })
    }

    override suspend fun getShops(): Either<Failure, List<ShopsUi>> {
        return apiCall (call = {
            vestaApi.getShops(manager.city?:0)
        },
            mapResponse = { shop -> shop.toUI() })
    }

    override suspend fun getStocks(): Either<Failure, List<StocksUi>> {
        return apiCall (call = {
            vestaApi.getStocks(manager.city?:0)
        },
            mapResponse = { stock -> stock.toUI() })
    }

    override suspend fun getNews(): Either<Failure, NewsUi> {
        return apiCall (call = {
            vestaApi.getNews(manager.city?:0)
        },
            mapResponse = { news -> news.toUI() })
    }

    override suspend fun getMainBlogs(): Either<Failure, MainBlogUi> {
        return apiCall (call = {
            vestaApi.getMainBlogs(manager.city?:0)
        },
            mapResponse = { blogs -> blogs.toUI() })
    }

    override suspend fun getBlogById(id: Int): Either<Failure, BlogByIdUi> {
        return apiCall (call = {
            vestaApi.getBlogById(
                id = id,
                city = manager.city?:0
            )
        },
            mapResponse = { blog -> blog.toUI() })
    }

}