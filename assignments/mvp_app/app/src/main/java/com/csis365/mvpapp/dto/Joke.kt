package com.csis365.mvpapp.dto

import com.google.gson.annotations.SerializedName

data class Joke(
    val id: String?,
    val url: String?,
    @SerializedName("icon_url")
    val iconUrl: String?,
    @SerializedName("value")
    val joke: String?
)