package com.example.groceryappproject.datalayer.model

data class SubcategoryResponse(
    val message: String,
    val status: Int,
    val subcategories: List<Subcategory>
)