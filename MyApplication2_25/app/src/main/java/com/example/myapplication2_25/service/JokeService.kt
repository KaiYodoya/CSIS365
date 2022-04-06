package com.example.myapplication2_25.service

import com.example.myapplication2_25.service.dto.Joke
import retrofit2.Call
import retrofit2.http.GET

interface JokeService {

    @GET("jokes/random")
    fun getJoke(): Call<Joke>

    //@GET("jokes/random")
    //fun getSpeceficJoke(): Call<Joke>
}