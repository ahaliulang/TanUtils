package me.tandeneck.tanutils.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.tandeneck.tanutils.db.PlaceDao
import me.tandeneck.tanutils.network.Network

/**
 * @Author:         tdn
 * @Time            2020/12/23
 * @Description:
 */
class PlaceRepository private constructor(
    private val placeDao: PlaceDao,
    private val network: Network
) {

    suspend fun getProvinceList() = withContext(Dispatchers.IO) {
        val result = placeDao.getProvinceList()
        if (result.isEmpty()) {
            result.addAll(network.fetchProvinceList())
            placeDao.saveProvinceList(result)
        }
        result
    }


    suspend fun getCityList(provinceId: Int) = withContext(Dispatchers.IO) {
        val result = placeDao.getCityList(provinceId)
        if (result.isEmpty()) {
            result.addAll(network.fetchCityList(provinceId))
            result.forEach { it.provinceId = provinceId }
            placeDao.saveCityList(result)
        }
        result
    }


    suspend fun getCountryList(provinceId: Int, cityId: Int) = withContext(Dispatchers.IO) {
        val result = placeDao.getCountryList(cityId)
        if (result.isEmpty()) {
            result.addAll(network.fetchCountyList(provinceId, cityId))
            result.forEach { it.cityId = cityId }
            placeDao.saveCountyList(result)
        }
        result
    }


    companion object {

        @Volatile
        private var instance: PlaceRepository? = null

        fun getInstance(placeDao: PlaceDao, network: Network): PlaceRepository {
            instance ?: synchronized(PlaceRepository::class.java) {
                instance ?: PlaceRepository(placeDao, network).also { instance = it }
            }
            return instance!!
        }
    }
}



























