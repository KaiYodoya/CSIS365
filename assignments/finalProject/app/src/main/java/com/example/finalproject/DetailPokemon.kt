package com.example.finalproject
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailPokemon : AppCompatActivity(){

    lateinit var name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_pokemon)

        var intent = intent
        val tmpUrl = intent.getStringExtra("tmpUrl")


        // call retrofit
        val service = PokeService.create()
        service.getSpeceficPokemon(tmpUrl!!).enqueue(object : Callback<Resource> {
            override fun onResponse(call: Call<Resource>, response: Response<Resource>) {
                Log.i("getAllPokemon", "onResponse()")

                // if retrofit success, "response" should have info of all pokemon
                if (response.isSuccessful) {
                    name = findViewById(R.id.name)
                    name.text = response.body()!!.forms[0]!!.name.toString()

                }
            }

            override fun onFailure(call: Call<Resource>, t: Throwable) {
                Log.e("getAllPokemon", "onFailure()")
            }
        })


    }
}