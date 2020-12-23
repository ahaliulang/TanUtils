package me.tandeneck.tanutils.db

import androidx.room.Database
import androidx.room.RoomDatabase
import me.tandeneck.tanutils.model.place.City
import me.tandeneck.tanutils.model.place.County
import me.tandeneck.tanutils.model.place.Province

/**
 * @Author:         tdn
 * @Time            2020/12/22
 * @Description:
 */
@Database(
    entities = [City::class, County::class, Province::class],
    version = 1,
    exportSchema = false
)
abstract class CoolWeatherDatabase : RoomDatabase() {

    abstract fun placeDao(): PlaceDao

}