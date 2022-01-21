package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.OperateCallback
import com.example.groceryappproject.datalayer.model.Category
import com.example.groceryappproject.datalayer.model.Product
import com.example.groceryappproject.datalayer.model.Subcategory
import com.example.groceryappproject.datalayer.model.User
import com.example.groceryappproject.datalayer.remote.MyRequestHandler

class RegistrationPresenter(val myRequestHandler: MyRequestHandler, val registrationView: RegistrationMVP.RegisterView):
RegistrationMVP.RegisterPresenter{
    override fun userRegistration(user: User) {
        registrationView.onLoad(true)
        myRequestHandler.registerUser(user, object: OperateCallback{
            override fun onLoginRegisterSuccess(message: String) {
                registrationView.onLoad(false)
                registrationView.setResult(message)
            }

            override fun onCategoriesSuccess(categories: List<Category>) {
            }

            override fun onSubcategoriesSuccess(subcategory: List<Subcategory>) {
            }

            override fun onProductsSuccess(products: List<Product>) {
            }

            override fun onError(message: String) {
                registrationView.onLoad(false)
                registrationView.setResult(message)
            }

        })
    }
}