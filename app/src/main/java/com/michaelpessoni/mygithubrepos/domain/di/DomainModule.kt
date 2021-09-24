package com.michaelpessoni.mygithubrepos.domain.di

import com.michaelpessoni.mygithubrepos.domain.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load( ){
        loadKoinModules(useCaseModule())
    }

    private fun useCaseModule(): Module {
        return module {
            factory {
                ListUserRepositoriesUseCase(get())
            }
        }
    }
}