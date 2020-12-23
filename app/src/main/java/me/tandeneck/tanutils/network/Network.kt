package me.tandeneck.tanutils.network

import me.tandeneck.tanutils.network.api.PlaceService
import me.tandeneck.tanutils.network.api.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
class Network {

    private val placeService = RetrofitManager.create(PlaceService::class.java)

    private val weatherService = RetrofitManager.create(WeatherService::class.java)

    suspend fun fetchProvinceList() = placeService.getProvinces().await()

    suspend fun fetchCityList(provinceId: Int) = placeService.getCities(provinceId).await()

    suspend fun fetchCountyList(provinceId: Int, cityId: Int) =
        placeService.getCounties(provinceId, cityId).await()

    suspend fun fetchWeather(weatherId: String) = weatherService.getWeather(weatherId).await()

    suspend fun fetchBingPic() = weatherService.getBingPic().await()


    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    body?.let { continuation.resume(it) } ?: continuation.resumeWithException(
                        RuntimeException("respponse body is null")
                    )
                }

                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}