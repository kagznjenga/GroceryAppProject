package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.remote.MyRequestHandler

class ProductsPresenter(val myRequestHandler: MyRequestHandler, val productsView: ProductsMVP.ProductsViewInt):
ProductsMVP.ProductsPresenterInt{
    override fun displayProducts(subcategoryId: String) {
        productsView.onLoad(true)

        myRequestHandler.loadProducts(subcategoryId, object: OperateCallback{
            override fun onLoginRegisterSuccess(message: String) {
            }

            override fun onCategoriesSuccess(categories: List<Category>) {
            }

            override fun onSubcategoriesSuccess(subcategories: List<Subcategory>) {
            }

            override fun onProductsSuccess(products: List<Product>) {
                productsView.onLoad(false)
                productsView.setResult(products)
            }

            override fun onError(message: String) {
                productsView.onLoad(false)
                productsView.setResult(emptyList())
            }

        } )
    }
}