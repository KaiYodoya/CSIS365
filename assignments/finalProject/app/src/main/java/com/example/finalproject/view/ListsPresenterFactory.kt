package com.example.finalproject.view

import com.example.finalproject.service.PokeListService

class ListsPresenterFactory {
    companion object {
        fun createPresenter(view: ListsView): ListsPresenter {
            return ListsPresenter(
                view,
                PokeListService()
                // context.getSharedPreferences("key", Context.MODE_PRIVATE))
            )
        }
    }
}