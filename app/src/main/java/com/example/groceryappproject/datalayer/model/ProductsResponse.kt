package com.example.groceryappproject.datalayer.model

data class ProductsResponse(
    val message: String,
    val products: List<Product>,
    val status: Int
)