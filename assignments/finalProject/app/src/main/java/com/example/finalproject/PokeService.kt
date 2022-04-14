package com.example.finalproject

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Resource
import com.example.finalproject.data.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeService {
    val api = RetrofitApiFactory().getPokemonApi()

    fun getPokemon(
        successCallback: (List<Results?>) -> Unit,
        failureCallback: (errorMessage: String) -> Unit,
        pageIndex: Int,
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

        /*
        val index = (pageIndex-1) * 20
        api.get20Pokemon(index).enqueue(object : Callback<Pokemon> {

            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.isSuccessful) {
                    val adapter = ListPokemonAdapter(response.body()!!.results, context)
                    recyclerview.adapter = adapter

                    adapter.setOnItemClickListener(object : ListPokemonAdapter.OnItemClickListener {

                        override fun onItemClick(position: Int) {
                            // Toast.makeText(this@ListPokemon, "You clicked on item no.$position", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    Log.e("getAllPokemon", "onFailure()")
            }

         */




        // })
    }
}