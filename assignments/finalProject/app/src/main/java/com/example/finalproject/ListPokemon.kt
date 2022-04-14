package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Results
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokemon : AppCompatActivity(), ListsView {
    lateinit var presenter: ListsPresenter

    lateinit var container: View
    lateinit var pageIndex: EditText
    lateinit var btnToRefresh: Button
    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pokemon)



        bindViews()
        presenter = ListsPresenterFactory.createPresenter(this)
        presenter.start()



        /*
        // Get first 20 pokemon for the first call
        PokeService().getPokemon(recyclerview, pageIndex.text.toString().toInt(), this)

        // Query other pages with user input number
        btnToRefresh.setOnClickListener {
            Log.d("Detail", "Button has been pressed.")
            PokeService().getPokemon(recyclerview, pageIndex.text.toString().toInt(), this)
        }

         */

    }

    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    //private fun bindPokemon()
    override fun bindPokemon(pokeList: List<Results?>)
    {
        recyclerview.layoutManager = LinearLayoutManager(this)
        //recyclerview.adapter = ListPokemonAdapter(pokeList, this)


        val adapter = ListPokemonAdapter(pokeList, this)
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : ListPokemonAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                // Toast.makeText(this@ListPokemon, "You clicked on item no.$position", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun findPageIndex():Int
    {
        return pageIndex.text.toString().toInt()
    }

    private fun bindViews()
    {
        supportActionBar!!.title = "Pokedex"
        container = findViewById(R.id.container)
        recyclerview = findViewById(R.id.recyclerView)
        pageIndex = findViewById(R.id.pageIndex)
        btnToRefresh = findViewById(R.id.btnToRefresh)
    }

}

