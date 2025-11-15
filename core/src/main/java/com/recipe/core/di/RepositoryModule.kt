package com.recipe.core.di

import com.recipe.core.repository.RecipesRepository
import com.recipe.core.repository.RecipesRepositoryImpl
import org.koin.dsl.module

val RepositoryModule = module {
    single<RecipesRepository> {
        RecipesRepositoryImpl(
            api = get(),
            recipeDao = get()
        )
    }
}