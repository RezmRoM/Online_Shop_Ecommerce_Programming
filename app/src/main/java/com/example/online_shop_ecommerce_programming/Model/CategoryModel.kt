package com.example.online_shop_ecommerce_programming.Model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryModel(
    val title: String = "",
    val id: Int = 0,
    @SerialName("pic_url")
    val picUrl: String = ""
)
