package me.tandeneck.tanutils.network

import me.tandeneck.tanutils.network.api.PlaceService
import me.tandeneck.tanutils.network.api.WeatherService
import retrofit2.Call
import kotlin.coroutines.suspendCoroutine

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
class Network {

    private val placeService = RetrofitManager.create(PlaceService::class.java)

    private val weatherService = RetrofitManager.create(WeatherService::class.java)


    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine {
        }
    }
}