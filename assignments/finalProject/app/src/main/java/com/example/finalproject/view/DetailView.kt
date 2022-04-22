package com.example.finalproject.view

import com.example.finalproject.data.Resource
import com.example.finalproject.data.Results

interface DetailView {
    fun bindDetail(pokeResponse: Resource)
    fun showError(errorMessage: String)
}