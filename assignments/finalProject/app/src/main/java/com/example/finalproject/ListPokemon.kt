package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokemon : AppCompatActivity() {
    lateinit var pageIndex: EditText
    lateinit var btnToRefresh: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pokemon)

        supportActionBar!!.title = "Pokedex"


        // RecyclerView set up
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)


        // Get first 20 pokemon for the first call
        //retrofitCall(recyclerview)
        PokeService().getPokemon(recyclerview, this)

        // Query other pages with user input number
        btnToRefresh = findViewById(R.id.btnToRefresh)
        btnToRefresh.setOnClickListener {
            Log.d("Detail", "Button has been pressed.")
            //retrofitCall(recyclerview)
            PokeService().getPokemon(recyclerview, this)
        }


        /*
        // Get All Pokemon
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

         */
    }

    /*
    fun retrofitCall(recyclerview: RecyclerView) {
        val service = PokeApi.create()
        pageIndex = findViewById(R.id.pageIndex)

        val index = (pageIndex.text.toString().toInt() -1) * 20
        service.get20Pokemon(index).enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                Log.i("get20Pokemon", "onResponse()")

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

     */


}

