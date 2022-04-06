package com.csis365.mvpapp.service

import com.csis365.mvpapp.dto.Fruit
import com.csis365.mvpapp.network.RetrofitApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitService {

    val api = RetrofitApiFactory().getFruityViceApi()

    fun getFruits(
        successCallback: (List<Fruit>) -> Unit,
        failureCallback: (errorMessage: String) -> Unit
    ) {
        api.getAllFruits().enqueue(object : Callback<List<Fruit>> {

            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No fruits returned from service")
                    }
                } else {
                    failureCallback("Error getting fruits")
                }
            }

            override fun onFailure(call: Call<List<Fruit>>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })
    }
}