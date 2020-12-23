package me.tandeneck.tanutils.db

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import me.tandeneck.tanutils.MyApplication
import me.tandeneck.tanutils.model.weather.Weather

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */

class WeatherSP {

    fun cacheWeatherInfo(weather: Weather?) {
        if (weather == null) return
        PreferenceManager.getDefaultSharedPreferences(MyApplication.context).edit {
            val weatherInfo = Gson().toJson(weather)
            putString("weather", weatherInfo)
        }
    }

    fun getCachedWeatherInfo(): Weather? {
        val weatherInfo =
            PreferenceManager.getDefaultSharedPreferences(MyApplication.context)
                .getString("weather", null)
        if (weatherInfo != null) {
            return Gson().fromJson(weatherInfo, Weather::class.java)
        }
        return null
    }

    fun cacheBingPic(bingPic: String?) {
        if (bingPic == null) return
        PreferenceManager.getDefaultSharedPreferences(MyApplication.context).edit {
            putString("bing_pic", bingPic)
        }
    }

    fun getCachedBingPic(): String? =
        PreferenceManager.getDefaultSharedPreferences(MyApplication.context)
            .getString("bing_pic", null)

    private fun SharedPreferences.edit(operation: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

}