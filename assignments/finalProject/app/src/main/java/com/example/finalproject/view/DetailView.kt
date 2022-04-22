package com.example.finalproject.view

import com.example.finalproject.data.Resource

interface DetailView {
    fun bindDetail(pokeResponse: Resource)
    fun showError(errorMessage: String)
}