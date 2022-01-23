package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.ProductDetails
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.remote.MyRequestHandler

class ProductDetialsPresenter(val myRequestHandler: MyRequestHandler, val detailsView: ProductDetailsMVP.ProductDetailsView):
    ProductDetailsMVP.ProdDetailsPresenterInt {
    override fun displayProdDetails(productId: String) {
        detailsView.onLoad(true)
        myRequestHandler.loadProductDetails(productId, object: OperateCallback{
            override fun onDetailsSuccess(productDetails: ProductDetails) {
                detailsView.onLoad(false)
                detailsView.setResult(productDetails)
            }

            override fun onLoginRegisterSuccess(message: String) {
            }

            override fun onCategoriesSuccess(categories: List<Category>) {
            }

            override fun onSubcategoriesSuccess(subcategories: List<Subcategory>) {
            }

            override fun onProductsSuccess(products: List<Product>) {
            }

            override fun onError(message: String) {
                detailsView.onLoad(false)
                detailsView.setResult(null)
            }
        })
    }
}