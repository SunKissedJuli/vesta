package com.example.vesta.di
import com.example.vesta.domain.manager.AuthManagerImpl
import com.example.vesta.domain.manager.AuthManager
import com.example.vesta.domain.manager.ObserverManager
import com.example.vesta.domain.manager.ObserverManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.core.module.dsl.bind

val managerModule = module {
  singleOf(::AuthManagerImpl) { bind<AuthManager>() }
  singleOf(::ObserverManagerImpl) { bind<ObserverManager>() }
}