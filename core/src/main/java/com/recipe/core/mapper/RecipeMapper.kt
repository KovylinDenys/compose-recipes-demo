package com.recipe.core.mapper

import com.recipe.core.database.dao.RecipeEntity
import com.recipe.core.model.Recipe
import com.recipe.core.repository.dto.RecipeResponse

fun RecipeResponse.toEntity(): RecipeEntity {
    return RecipeEntity(
        id = id,
        title = title,
        ingredients = ingredients,
        instructions = instructions,
        imageUrl = imageUrl
    )
}

fun RecipeEntity.toDomain(): Recipe {
    return Recipe(
        id = id,
        title = title,
        ingredients = ingredients,
        instructions = instructions,
        imageUrl = imageUrl
    )
}