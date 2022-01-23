package com.example.groceryappproject.datalayer.model

data class ProductDetailsResponse(
    val message: String,
    val product: ProductDetails,
    val status: Int
)