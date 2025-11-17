package com.recipe.core.network.api

import com.recipe.core.repository.dto.RecipeDetailsResponse
import com.recipe.core.repository.dto.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipesApi {

    @GET("/recipes")
    suspend fun getRecipes(): List<RecipeResponse>

    @GET("/recipes/{id}")
    suspend fun getRecipeDetails(@Path("id") id: Int): RecipeDetailsResponse
}