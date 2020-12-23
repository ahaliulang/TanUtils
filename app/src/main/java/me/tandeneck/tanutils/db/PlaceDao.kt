package me.tandeneck.tanutils.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import me.tandeneck.tanutils.model.place.City
import me.tandeneck.tanutils.model.place.County
import me.tandeneck.tanutils.model.place.Province

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
@Dao
interface PlaceDao {

    @Query("SELECT * FROM Province")
    fun getProvinceList(): MutableList<Province>

    @Query("SELECT * FROM City WHERE provinceId = :provinceId")
    fun getCityList(provinceId: Int): MutableList<City>

    @Query("SELECT * FROM County WHERE cityId = :cityId")
    fun getCountryList(cityId: Int): MutableList<County>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProvinceList(provinceList: List<Province>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCityList(cityList: List<City>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCountyList(countyList: List<County>)

}
