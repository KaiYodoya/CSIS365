package com.csis365.mvpapp.network

import com.csis365.mvpapp.dto.Fruit
import retrofit2.Call
import retrofit2.http.GET

interface FruityViceApi {

    @GET("fruit/all")
    fun getAllFruits(): Call<List<Fruit>>

}