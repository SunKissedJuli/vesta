package com.example.vesta.di

import com.example.vesta.data.repositoryImpl.ProductRepositoryImpl
import com.example.vesta.domain.repository.InfoRepository
import com.example.vesta.data.repositoryImpl.InfoRepositoryImpl
import com.example.vesta.domain.repository.ProductRepository
import com.example.vesta.domain.repository.UserRepository
import com.example.vesta.data.repositoryImpl.UserRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

val repositoryModule = module {
    factoryOf(::ProductRepositoryImpl) { bind<ProductRepository>() }
    factoryOf(::InfoRepositoryImpl) { bind<InfoRepository>() }
    factoryOf(::UserRepositoryImpl) { bind<UserRepository>() }
}

