package com.example.vesta.di

import com.example.vesta.data.repositoryImpl.ProductRepositoryImpl
import com.example.vesta.domain.repository.ProductRepository
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    factoryOf(::ProductRepositoryImpl) { bind<ProductRepository>() }
}

