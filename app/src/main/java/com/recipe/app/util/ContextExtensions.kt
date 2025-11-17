package com.recipe.app.util

import android.content.Context

fun Context.loadJsonAsset(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}