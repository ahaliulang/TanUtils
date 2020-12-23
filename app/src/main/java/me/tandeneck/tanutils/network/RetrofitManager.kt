package me.tandeneck.tanutils.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
object RetrofitManager {
    private const val BASE_URL = "http://guolin.tech/"
    private const val WRITE_TIMEOUT = 30L
    private const val READ_TIMEOUT = 20L
    private const val CONNECT_TIMEOUT = 15L


    private val httpClient = OkHttpClient.Builder()
        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor())

    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit = builder.build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

}