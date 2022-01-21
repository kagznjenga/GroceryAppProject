package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory

class ProductsMVP {
    interface ProductsViewInt{
        fun setResult(products: List<Product>)
        fun onLoad(isLoading: Boolean)
    }

    interface ProductsPresenterInt{
        fun displayProducts(subcategoryId: String)
    }
}