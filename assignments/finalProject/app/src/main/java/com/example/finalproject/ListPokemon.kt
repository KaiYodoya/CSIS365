package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pokemon)


        supportActionBar!!.title = "Pokedex"


        // RecyclerView set up
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // call retrofit
        val service = PokeService.create()
        service.getAllPokemon().enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                Log.i("getAllPokemon", "onResponse()")

                // if retrofit success, "response" should have info of all pokemon
                if (response.isSuccessful) {
                    val adapter = ListPokemonAdapter(response.body()!!.results, this@ListPokemon)
                    recyclerview.adapter = adapter

                    adapter.setOnItemClickListener(object: ListPokemonAdapter.OnItemClickListener{

                        override fun onItemClick(position: Int){
                            // Toast.makeText(this@ListPokemon, "You clicked on item no.$position", Toast.LENGTH_SHORT).show()
                        }
                    })
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Log.e("getAllPokemon", "onFailure()")
            }
        })

    }
}


/*
// Check if RecyclerView is working
val dataset = listOf(
    Pokemon(Results("pokemon1", "str1")),
    Pokemon(Results("pokemon2", "str2")),
    Pokemon(Results("pokemon3", "str3")),
    Pokemon(Results("pokemon4", "str4")),
    Pokemon(Results("pokemon5", "str5"))
)

val adapter = ListPokemon_Adapter(dataset)
recyclerview.adapter = adapter
 */