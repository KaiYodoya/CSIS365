package com.example.myapplication2_25.service.dto

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("icon_url")
    val iconUrl: String?,
    val id: String?,
    val url: String?,
    @SerializedName("value")
    val jokeString: String?
) {

}
