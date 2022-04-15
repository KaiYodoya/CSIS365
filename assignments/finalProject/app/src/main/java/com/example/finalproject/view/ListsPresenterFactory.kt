package com.example.finalproject.view

import com.example.finalproject.service.PokeService

class ListsPresenterFactory {
    companion object {
        fun createPresenter(view: ListsView): ListsPresenter {
            return ListsPresenter(
                view,
                PokeService()
                // context.getSharedPreferences("key", Context.MODE_PRIVATE))
            )
        }
    }
}