package me.tandeneck.tanutils.http

import me.tandeneck.tanutils.http.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * author:tandeneck
 * time:2020/12/14
 * description:
 */
object RetrofitManager {

    private const val API_BASE_URL = ""

    val apiService: ApiService = lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        retrofit.create(ApiService::class.java)
    }.value


    private val retrofit: Retrofit
        private get() {
            val builder = OkHttpClient.Builder()
            builder.writeTimeout(30, TimeUnit.SECONDS)
            builder.readTimeout(20, TimeUnit.SECONDS)
            builder.connectTimeout(15, TimeUnit.SECONDS)
            builder.addInterceptor(HttpLoggingInterceptor())

            val okHttpClient = builder.build()
            return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }


}