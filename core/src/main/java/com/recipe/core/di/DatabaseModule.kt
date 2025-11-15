package com.recipe.core.di

import androidx.room.Room
import com.recipe.core.database.RecipesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val RECIPES_DB = "recipes.db"

val DatabaseModule = module {
    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = RecipesDatabase::class.java,
            name = RECIPES_DB
        ).build()
    }

    factory { get<RecipesDatabase>().recipeDao() }
}