package com.example.fitpeo.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PhotoRes (
    @SerializedName("albumId"      ) var albumId      : Int?    = null,
    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("title"        ) var title        : String? = null,
    @SerializedName("url"          ) var url          : String? = null,
    @SerializedName("thumbnailUrl" ) var thumbnailUrl : String? = null
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(albumId)
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(url)
        parcel.writeString(thumbnailUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PhotoRes> {
        override fun createFromParcel(parcel: Parcel): PhotoRes {
            return PhotoRes(parcel)
        }

        override fun newArray(size: Int): Array<PhotoRes?> {
            return arrayOfNulls(size)
        }
    }

}
