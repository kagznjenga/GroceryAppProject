package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.remote.MyRequestHandler

class HomePresenter(val myRequestHandler: MyRequestHandler, val homeView: HomeMVP.HomeViewInt):
HomeMVP.HomePresenterInt{
    override fun displayCategories() {
        homeView.onLoad(true)

        myRequestHandler.loadCategories(object: OperateCallback{
            override fun onCategoriesSuccess(categories: List<Category>) {
                homeView.onLoad(false)
                homeView.setResult(categories)
            }

            override fun onLoginRegisterSuccess(message: String) {
            }

            override fun onProductsSuccess(products: List<Product>) {
            }

            override fun onSubcategoriesSuccess(subcategory: List<Subcategory>) {
            }

            override fun onError(message: String) {
                homeView.onLoad(false)
                homeView.setResult(emptyList())
            }
        })
    }
}