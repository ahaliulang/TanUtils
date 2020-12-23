package me.tandeneck.tanutils.network.api

import me.tandeneck.tanutils.model.weather.HeWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
interface WeatherService {
    @GET("api/weather")
    suspend fun getWeather(@Query("cityid") weatherId: String): Call<HeWeather>

    @GET("api/bing_pic")
    fun getBingPic(): Call<String>
}