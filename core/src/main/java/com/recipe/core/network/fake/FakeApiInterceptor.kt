package com.recipe.core.network.fake

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONArray

class FakeApiInterceptor(
    private val recipesJson: String,
    private val recipesDetailsJson: String
) : Interceptor {

    private val details: Map<Int, String> = run {
        val array = JSONArray(recipesDetailsJson)
        (0 until array.length()).associate { i ->
            val obj = array.getJSONObject(i)
            val id = obj.getInt("id")
            id to obj.toString()
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        Thread.sleep((300..1200).random().toLong())

        val request = chain.request()
        val method = request.method
        val path = request.url.encodedPath

        val json = when {
            method == "GET" && path == "/recipes" -> recipesJson

            method == "GET" && path.matches(Regex("^/recipes/\\d+$")) -> {
                val id = path.substringAfterLast("/").toInt()
                details[id]
            }

            else -> null
        }

        return if (json != null) {
            fakeJsonResponse(request, json)
        } else {
            chain.proceed(request)
        }
    }

    private fun fakeJsonResponse(request: Request, json: String): Response {
        return Response.Builder()
            .code(200)
            .message("OK")
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .body(json.toResponseBody("application/json".toMediaType()))
            .addHeader("content-type", "application/json")
            .build()
    }
}