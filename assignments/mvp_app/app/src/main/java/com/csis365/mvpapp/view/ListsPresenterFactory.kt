package com.csis365.mvpapp.view

import android.content.Context
import com.csis365.mvpapp.service.FruitService
import com.csis365.mvpapp.service.JokeService

class ListsPresenterFactory {

    companion object {
        fun createPresenter(view: ListsView, context: Context): ListsPresenter {
            return ListsPresenter(
                view,
                FruitService(),
                JokeService(),
                context.getSharedPreferences("key", Context.MODE_PRIVATE))
        }
    }
}