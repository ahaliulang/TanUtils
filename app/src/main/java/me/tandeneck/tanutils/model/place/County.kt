package me.tandeneck.tanutils.model.place

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class County(
    @SerializedName("name") val countyName: String,
    @SerializedName("weather_id") val weatherId: String
) {
    @PrimaryKey
    @Transient
    val id = 0
    var cityId = 0
}