package com.example.vesta.di

import com.example.vesta.data.api.VestaApi
import de.jensklingenberg.ktorfit.Ktorfit
import org.koin.dsl.module

internal val apiModule = module {
    factory { get<Ktorfit>().create<VestaApi>() }
}