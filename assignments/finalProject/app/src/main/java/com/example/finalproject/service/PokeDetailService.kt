package com.example.finalproject.service

import com.example.finalproject.data.PokemonDetail
import com.example.finalproject.network.RetrofitApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeDetailService {
    private val api = RetrofitApiFactory().getPokemonApi()

    fun getDetail(
        successCallback: (PokemonDetail) -> Unit,
        failureCallback: (errorMessage: String) -> Unit,
        tmpUrl: String
    ){
        api.getSpecificPokemon(tmpUrl).enqueue(object : Callback<PokemonDetail> {
            override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No pokemon returned from service")
                    }
                } else {
                    failureCallback("Error getting pokemon")
                }
            }

            override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }
}