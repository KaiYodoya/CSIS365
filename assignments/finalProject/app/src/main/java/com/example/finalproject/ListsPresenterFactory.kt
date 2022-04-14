package com.example.finalproject

import android.content.Context

class ListsPresenterFactory {
    companion object {
        fun createPresenter(view: ListsView): ListsPresenter {
            return ListsPresenter(
                view,
                PokeService()
            )
                // context.getSharedPreferences("key", Context.MODE_PRIVATE))
        }
    }
}