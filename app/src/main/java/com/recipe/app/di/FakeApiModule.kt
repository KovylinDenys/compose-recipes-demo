package com.recipe.app.di

import com.recipe.app.util.loadJsonAsset
import com.recipe.core.network.fake.FakeApiInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val FakeApiModule = module {
    single {
        val recipesJson = androidContext().loadJsonAsset("recipes.json")
        val recipesDetailsJson = androidContext().loadJsonAsset("recipes_details.json")

        FakeApiInterceptor(
            recipesJson = recipesJson,
            recipesDetailsJson = recipesDetailsJson
        )
    }
}