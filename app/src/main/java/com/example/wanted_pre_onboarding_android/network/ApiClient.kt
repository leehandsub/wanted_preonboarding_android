package com.example.wanted_pre_onboarding_android.network

import com.example.wanted_pre_onboarding_android.common.API_KEY
import com.example.wanted_pre_onboarding_android.model.NewsResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("v2/top-headlines")
    suspend fun getTopNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY

    ): NewsResponse

    @GET("v2/top-headlines")
    suspend fun getCategory(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    companion object {

        private const val baseUrl = "https://newsapi.org"

        fun create(): ApiClient {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}