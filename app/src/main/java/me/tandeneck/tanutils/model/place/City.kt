package me.tandeneck.tanutils.model.place

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class City(@SerializedName("name") val cityName: String, @SerializedName("id") val cityCode: Int) {
    @PrimaryKey
    @Transient
    val id = 0
    var provinceId = 0
}