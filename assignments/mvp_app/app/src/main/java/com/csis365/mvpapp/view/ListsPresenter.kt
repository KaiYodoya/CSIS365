package com.csis365.mvpapp.view

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.csis365.mvpapp.service.FruitService
import com.csis365.mvpapp.service.JokeService

class ListsPresenter(
    val view: ListsView,
    val fruitService: FruitService,
    val jokeService: JokeService,
    val sharedPreferences: SharedPreferences
) {

    fun start() {
        getFruits()
        getJoke()
        getCategories()

        saveValue()
    }


    fun getJoke(category: String) {
        jokeService.getJoke(
            category,

            successCallback = { joke ->
                view.bindJoke(joke)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

    private fun getFruits() {
        fruitService.getFruits(
            successCallback = { fruits ->
                view.bindFruits(fruits)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

    private fun getJoke() {
        jokeService.getJoke(
            successCallback = { joke ->
                view.bindJoke(joke)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

    private fun getCategories() {
        jokeService.getCategories(
            successCallback = { categories ->
                view.bindCategories(categories)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            }
        )
    }

    private fun saveValue() {
        val editor = sharedPreferences.edit()
        editor.putString("unique key", "whatever string")
        editor.commit()

        val recalledString = sharedPreferences.getString("unique key", "default")
        view.showError(recalledString!!)
    }
}
