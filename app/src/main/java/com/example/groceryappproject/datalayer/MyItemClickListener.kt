package com.example.groceryappproject.datalayer

interface MyItemClickListener {
    fun onCategoryClicked(categoryId: String)
    fun onSubcategoryClicked(subcategoryId: String)
    fun onProductClicked(productId: String)
}