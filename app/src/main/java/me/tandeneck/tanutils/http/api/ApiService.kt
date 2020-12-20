package me.tandeneck.tanutils.http.api

import io.reactivex.rxjava3.core.Maybe
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


/**
 * author:tandeneck
 * time:2020/12/14
 * description:
 */
interface ApiService {

    @GET("api/querys/pm2_5.json")
    fun pm25(
        @QueryMap map: Map<String, Any>
    ): Maybe<List<Any>>

    @GET("api/querys/pm10.json")
    fun pm10(
        @Query("city") cityId: String?,
        @Query("token") token: String?
    ): Maybe<List<Any>>

    @GET("api/querys/so2.json")
    fun so2(
        @Query("city") cityId: String?,
        @Query("token") token: String?
    ): Maybe<List<Any>>
}