package com.recipe.core.common

inline fun <T> safeCall(block: () -> T): DataResult<T> {
    return try {
        DataResult.Success(block())
    } catch (e: Exception) {
        DataResult.Error(message = e.message, cause = e)
    }
}