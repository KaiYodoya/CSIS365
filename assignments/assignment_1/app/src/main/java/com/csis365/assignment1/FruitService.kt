package com.csis365.assignment1

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitService {

    @GET("api/fruit/all")
    fun getAllFruit(): Call<List<Fruit>>

    // Didn't use it, bring all info to Detail using intent
    // @GET("api/fruit/{id}")
    // fun getFruit(@Path("id") id: Int): Call<Fruit>

    companion object {

        var BASE_URL = "https://fruityvice.com/"

        fun create(): FruitService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(FruitService::class.java)

        }
    }
}



