package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.remote.MyRequestHandler

class SubcategoryPresenter(val myRequestHandler: MyRequestHandler, val subcategoryView: SubcategoryMVP.SubcategoryViewInt):
SubcategoryMVP.SubcategoryPresenterInt{
    override fun displaySubcategories(categoryId: String) {
        subcategoryView.onLoad(true)

        myRequestHandler.loadSubcategories(categoryId, object: OperateCallback{
            override fun onSubcategoriesSuccess(subcategories: List<Subcategory>) {
                subcategoryView.onLoad(false)
                subcategoryView.setResult(subcategories)
            }

            override fun onLoginRegisterSuccess(message: String) {
            }

            override fun onCategoriesSuccess(categories: List<Category>) {
            }

            override fun onProductsSuccess(products: List<Product>) {
            }

            override fun onError(message: String) {
                subcategoryView.onLoad(false)
                subcategoryView.setResult(emptyList())
            }

        })
    }
}