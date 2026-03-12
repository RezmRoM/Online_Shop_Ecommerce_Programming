package com.example.online_shop_ecommerce_programming.Model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemsModel(
    var title: String = "",
    var description: String = "",
    @SerialName("pic_urls")
    var picUrl: List<String> = emptyList(),
    @SerialName("models")
    var model: List<String> = emptyList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0,
    @SerialName("show_recommended")
    var showRecommended: Boolean = false,
    @SerialName("category_id")
    var categoryId: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArrayList()?.toList() ?: emptyList(),
        parcel.createStringArrayList()?.toList() ?: emptyList(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeStringList(picUrl)
        parcel.writeStringList(model)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeInt(numberInCart)
        parcel.writeByte(if (showRecommended) 1 else 0)
        parcel.writeInt(categoryId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(parcel: Parcel): ItemsModel {
            return ItemsModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemsModel?> {
            return arrayOfNulls(size)
        }
    }
}
