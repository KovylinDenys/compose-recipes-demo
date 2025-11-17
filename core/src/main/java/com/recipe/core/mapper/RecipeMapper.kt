package com.recipe.core.mapper

import com.recipe.core.database.dao.RecipeEntity
import com.recipe.core.model.Recipe
import com.recipe.core.model.RecipeDetails
import com.recipe.core.repository.dto.RecipeDetailsResponse
import com.recipe.core.repository.dto.RecipeResponse

// --- List mapping ---

fun RecipeResponse.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = id,
        title = title,
        ingredients = ingredients,
        shortDescription = shortDescription,
        imageUrl = imageUrl
    )
}

fun RecipeEntity.toDomain(): Recipe {
    return Recipe(
        id = id,
        title = title,
        ingredients = ingredients,
        shortDescription = shortDescription,
        imageUrl = imageUrl
    )
}

// --- Details mapping ---

fun RecipeDetailsResponse.toDomain(): RecipeDetails {
    return RecipeDetails(
        id = id,
        title = title,
        ingredients = ingredients,
        fullDescription = fullDescription,
        instructions = instructions,
        imageUrl = imageUrl
    )
}