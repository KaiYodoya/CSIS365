package com.example.finalproject.network

import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.PokemonDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApi {

    @GET("pokemon?&limit=20")
    fun get20Pokemon(@Query("offset") index: Int): Call<Pokemon>

    @GET("{url}")
    fun getSpecificPokemon(@Path("url") url: String): Call<PokemonDetail>
}


