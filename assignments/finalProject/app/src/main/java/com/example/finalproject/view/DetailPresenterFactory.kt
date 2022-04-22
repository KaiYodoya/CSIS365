package com.example.finalproject.view

import com.example.finalproject.service.PokeDetailService

class DetailPresenterFactory {
    companion object {
        fun createPresenter(view: DetailView, tmpURL: String): DetailPresenter {
            return DetailPresenter(
                view,
                PokeDetailService(),
                tmpURL
                // context.getSharedPreferences("key", Context.MODE_PRIVATE))
            )
        }
    }
}