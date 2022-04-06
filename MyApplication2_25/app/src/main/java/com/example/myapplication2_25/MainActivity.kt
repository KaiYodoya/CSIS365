package com.example.myapplication2_25

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2_25.service.JokeService
import com.example.myapplication2_25.service.dto.Joke
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jokeService = buildService()
        jokeService.getJoke().enqueue(object : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                Log.i("asdf", "onResponse()")
            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.e("asdf", "onFailure()")
            }

        })



    }

    private fun buildService(): JokeService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //val service: JokeService = retrofit.create(JokeService::class.java)
        return retrofit.create(JokeService::class.java)
    }
}