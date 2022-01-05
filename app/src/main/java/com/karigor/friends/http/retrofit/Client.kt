package com.karigor.friends.http.retrofit

import android.net.NetworkRequest
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Request
import java.util.concurrent.TimeUnit
import kotlin.Throws

object Client {
    private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    /**
     * Gets client.
     *
     * @param BASE_URL  the base url
     * @param authToken the auth token
     * @return the client
     */
    fun getClient(BASE_URL: String?, authToken: String): Retrofit? {
        if (okHttpClient == null) initOkHttp(authToken)
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    private fun initOkHttp(authToken: String) {
        val REQUEST_TIMEOUT = 70
        val httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val requestBuilder: Request.Builder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Request-Type", "")
                .addHeader("Authorization", "Bearer $authToken")
                .addHeader("Content-Type", "application/json")
            val request: Request = requestBuilder.build()
            chain.proceed(request)
        })
        okHttpClient = httpClient.build()
    }

    /**
     * Reset api client.
     */
    fun resetApiClient() {
        retrofit = null
        okHttpClient = null
    }
}