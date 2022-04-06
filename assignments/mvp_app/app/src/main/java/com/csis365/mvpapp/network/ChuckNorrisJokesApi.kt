package com.csis365.mvpapp.network

import com.csis365.mvpapp.dto.Fruit
import com.csis365.mvpapp.dto.Joke
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisJokesApi {

    @GET("jokes/categories")
    fun getCategories(): Call<List<String>>

    @GET("jokes/random")
    fun getJoke(): Call<Joke>

    @GET("jokes/random")
    fun getJoke(@Query("category") category: String): Call<Joke>
}