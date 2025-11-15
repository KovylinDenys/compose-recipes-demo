package com.recipe.core.network.api

import com.recipe.core.repository.dto.RecipeResponse
import retrofit2.http.GET

interface RecipesApi {

    @GET("recipes")
    suspend fun getRecipes(): List<RecipeResponse>
}