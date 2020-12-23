package me.tandeneck.tanutils.network.api

import me.tandeneck.tanutils.model.place.City
import me.tandeneck.tanutils.model.place.County
import me.tandeneck.tanutils.model.place.Province
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
interface PlaceService {
    @GET("api/china")
    fun getProvinces(): Call<MutableList<Province>>

    @GET("api/china/{provinceId}")
    fun getCities(@Path("provinceId") provinceId: Int): Call<MutableList<City>>

    @GET("api/china/{provinceId}/{cityId}")
    fun getCounties(@Path("provinceId") provinceId: Int, @Path("cityId") cityId: Int): Call<MutableList<County>>
}