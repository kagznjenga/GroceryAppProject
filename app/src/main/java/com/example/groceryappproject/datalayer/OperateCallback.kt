package com.example.groceryappproject.datalayer

import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory

interface OperateCallback {
    fun onLoginRegisterSuccess(message: String)
    fun onCategoriesSuccess(categories: List<Category>)
    fun onSubcategoriesSuccess(subcategories: List<Subcategory>)
    fun onProductsSuccess(products: List<Product>)
    fun onError(message: String)
}