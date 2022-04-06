package com.example.finalproject.data

data class Resource(
    val forms: Forms?
    )

data class Forms(
    val indexForms: IndexForms?
    )

data class IndexForms(
    val name: String?
    )