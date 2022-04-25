package com.example.finalproject.service

import com.example.finalproject.network.RetrofitApiFactory
import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeListService {
    private val api = RetrofitApiFactory().getPokemonApi()

    fun getPokemon(
        successCallback: (List<Results?>) -> Unit,
        failureCallback: (errorMessage: String) -> Unit,
        pageIndex: Int
    ) {
        val index = (pageIndex-1) * 20
        api.get20Pokemon(index).enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it.results)
                    } ?: run {
                        failureCallback("No pokemon returned from service")
                    }
                } else {
                    failureCallback("Error getting pokemon")
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }
}