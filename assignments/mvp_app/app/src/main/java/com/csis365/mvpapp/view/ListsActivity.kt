package com.csis365.mvpapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.csis365.mvpapp.R
import com.csis365.mvpapp.dto.Fruit
import com.csis365.mvpapp.dto.Joke
import com.csis365.mvpapp.service.FruitService
import com.google.android.material.snackbar.Snackbar


class ListsActivity : AppCompatActivity(), ListsView {

    val presenter = ListsPresenterFactory.createPresenter(this, this)

    lateinit var container: View
    lateinit var ivJokeIcon: ImageView
    lateinit var tvJokeOfTheDay: TextView
    lateinit var rvFruits: RecyclerView
    lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lists)

        bindViews()

        presenter.start()
    }

    override fun bindFruits(fruits: List<Fruit>) {
        rvFruits.layoutManager = LinearLayoutManager(this)
        rvFruits.adapter = FruitListAdapter(fruits)
    }

    override fun bindJoke(joke: Joke) {
        Glide
            .with(this)
            .load(joke.iconUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(ivJokeIcon)
        tvJokeOfTheDay.text = joke.joke
    }

    override fun bindCategories(categories: List<String>) {
        rvCategories.layoutManager = LinearLayoutManager(this)
        rvCategories.adapter = CategoriesAdapter(categories) { category ->
            presenter.getJoke(category)
        }
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(container, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private fun bindViews() {
        container = findViewById(R.id.container)
        ivJokeIcon = findViewById(R.id.iv_joke_icon)
        tvJokeOfTheDay = findViewById(R.id.tv_joke_of_the_day)
        rvFruits = findViewById(R.id.rv_fruits)
        rvCategories = findViewById(R.id.rv_categories)
    }
}