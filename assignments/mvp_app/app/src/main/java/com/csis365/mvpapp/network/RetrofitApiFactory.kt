package com.csis365.mvpapp.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiFactory {

    fun getFruityViceApi(): FruityViceApi {
        return Retrofit.Builder()
            .baseUrl("https://www.fruityvice.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FruityViceApi::class.java)
    }

    fun getChuckNorrisJokeApi(): ChuckNorrisJokesApi {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisJokesApi::class.java)
    }
}