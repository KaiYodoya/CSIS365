package com.example.finalproject.view

import com.example.finalproject.service.PokeDetailService

class DetailPresenter(
    private val view: DetailView,
    private val pokeDetailService: PokeDetailService,
    private val tmpURL: String
) {
    fun start() {
        getDetail()
    }

    private fun getDetail() {
        pokeDetailService.getDetail(
            successCallback = { resource ->
                view.bindDetail(resource)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            },

            tmpURL
        )
    }

}