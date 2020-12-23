package me.tandeneck.tanutils.model.place

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class Province(
    @SerializedName("name") val provinceName: String,
    @SerializedName("id") val provinceCode: Int
) {
    @PrimaryKey
    @Transient
    val id = 0
}