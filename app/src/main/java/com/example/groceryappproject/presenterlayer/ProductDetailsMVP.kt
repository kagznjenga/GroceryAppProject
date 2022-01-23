package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.model.ProductDetails

class ProductDetailsMVP {
    interface ProductDetailsView{
        fun setResult(productDetails: ProductDetails?)
        fun onLoad(isLoading: Boolean)
    }
    interface ProdDetailsPresenterInt{
        fun displayProdDetails(productId: String)
    }
}