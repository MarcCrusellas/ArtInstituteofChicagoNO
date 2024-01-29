package com.example.artinstituteofchicagono.data.room.small

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.artinstituteofchicagono.data.modelv2.SmallData
import com.example.artinstituteofchicagono.obj.DateObj.formatToString
import com.example.artinstituteofchicagono.obj.DateObj.getCurrentDateTime

@Entity
data class SmallPaint(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val artist_display: String?,
    val artist_id: Int?,
    val artist_title: String?,
    val date_display: String?,
    val image_id: String?,
    val main_reference_number: String?,
    val title: String?,
    val time: String? = getCurrentDateTime().formatToString("dd/MM/yyyy"),
    var fab : Boolean = false
) : Parcelable {

    constructor(d: SmallData) : this(
        d.id,
        d.artist_display,
        d.artist_id,
        d.artist_title,
        d.date_display,
        d.image_id,
        d.main_reference_number,
        d.title
    )


    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(artist_display)
        parcel.writeValue(artist_id)
        parcel.writeString(artist_title)
        parcel.writeString(date_display)
        parcel.writeString(image_id)
        parcel.writeString(main_reference_number)
        parcel.writeString(title)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SmallPaint> {
        override fun createFromParcel(parcel: Parcel): SmallPaint {
            return SmallPaint(parcel)
        }

        override fun newArray(size: Int): Array<SmallPaint?> {
            return arrayOfNulls(size)
        }
    }


}
