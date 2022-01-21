package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.remote.MyRequestHandler

class LoginPresenter(val myRequestHandler: MyRequestHandler, val loginView: LoginMVP.LoginView):
LoginMVP.LoginPresenterMVP {
    override fun loginUser(email: String, password: String){
        loginView.onLoad(true)
        myRequestHandler.login(email, password, object: OperateCallback{
            override fun onLoginRegisterSuccess(message: String) {
                loginView.onLoad(false)
                loginView.setResult(message)
            }

            override fun onCategoriesSuccess(categories: List<Category>) {
            }

            override fun onProductsSuccess(products: List<Product>) {
            }

            override fun onSubcategoriesSuccess(subcategory: List<Subcategory>) {
            }

            override fun onError(message: String) {
                loginView.onLoad(false)
                loginView.setResult(message)
            }

        } )
    }

}