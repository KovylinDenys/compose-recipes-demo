package com.recipe.core.common

sealed class DataResult<out T> {
    data class Success<T>(val data: T) : DataResult<T>()

    data class Error(
        val message: String? = null,
        val cause: Throwable? = null
    ) : DataResult<Nothing>()
}