package com.csis365.mvpapp.view

import com.csis365.mvpapp.dto.Fruit
import com.csis365.mvpapp.dto.Joke

interface ListsView {
    fun bindFruits(fruits: List<Fruit>)
    fun bindJoke(joke: Joke)
    fun showError(errorMessage: String)
    fun bindCategories(categories: List<String>)
}
