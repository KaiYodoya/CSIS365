package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Results

class ListPokemon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pokemon)


        // RecyclerView set up
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        var dataset = listOf(
            Pokemon(Results("pokemon1", "str")),
            Pokemon(Results("pokemon2", "str")),
            Pokemon(Results("pokemon3", "str")),
            Pokemon(Results("pokemon4", "str")),
            Pokemon(Results("pokemon5", "str"))
        )

        val adapter = ListPokemon_Adapter(dataset)
        recyclerview.adapter = adapter

    }
}


    /*
    val p1 = Pokemon(Results("pokemon1", "str"))
        val p2 = Pokemon(Results("pokemon2", "str"))
        val p3 = Pokemon(Results("pokemon3", "str"))
        val p4 = Pokemon(Results("pokemon4", "str"))
        val p5 = Pokemon(Results("pokemon5", "str"))
     */