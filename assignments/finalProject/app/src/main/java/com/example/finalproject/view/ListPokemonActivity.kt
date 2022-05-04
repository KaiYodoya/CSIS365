package com.example.finalproject.view

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.data.Results
import com.google.android.material.snackbar.Snackbar

class ListPokemonActivity : AppCompatActivity(), ListsView {
    lateinit var presenter: ListsPresenter

    lateinit var container: View
    lateinit var pageIndex: EditText
    lateinit var btnToRefresh: Button
    lateinit var recyclerview: RecyclerView

    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("asdf", "${pageIndex.text}")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_pokemon)

        bindViews()

        presenter = ListsPresenterFactory.createPresenter(this)
        presenter.start()

    }

    override fun onDestroy() {
        Log.d("asdf", "${pageIndex.text}")
        super.onDestroy()
        val editor = sp.edit()
        editor.putInt("PageIndexNum", pageIndex.text.toString().toInt())
        editor.apply()
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
        val isPageIndex = pageIndex.text.toString().toIntOrNull()
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
        btnToRefresh = findViewById(R.id.btnToRefresh)

        pageIndex = findViewById(R.id.pageIndex)
        sp = getSharedPreferences("PageIndexNum", Context.MODE_PRIVATE)
        val pageIndexNum: Int = sp.getInt("PageIndexNum", 1)
        pageIndex.setText(pageIndexNum.toString())
    }

}

