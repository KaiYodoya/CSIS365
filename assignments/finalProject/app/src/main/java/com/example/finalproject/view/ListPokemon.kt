package com.example.finalproject.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.Results
import com.google.android.material.snackbar.Snackbar

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

    }

    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun bindPokemon(pokeList: List<Results?>)
    {
        recyclerview.layoutManager = LinearLayoutManager(this)

        val adapter = ListPokemonAdapter(pokeList, this)
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : ListPokemonAdapter.OnItemClickListener {

            override fun onItemClick(position: Int) {
                // Toast.makeText(this@ListPokemon, "You clicked on item no.$position", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun queryBtn(): Button
    {
        return btnToRefresh
    }

    override fun findPageIndex():Int
    {
        var isPageIndex = pageIndex.text.toString().toIntOrNull()
        if (isPageIndex == null)
        {
            pageIndex.setText("1")
        }
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
