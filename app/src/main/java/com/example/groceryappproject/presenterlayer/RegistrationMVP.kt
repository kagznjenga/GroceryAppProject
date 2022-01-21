package com.example.groceryappproject.presenterlayer

import com.example.groceryappproject.datalayer.model.User

class RegistrationMVP {
    interface RegisterView{
        fun setResult(message: String)
        fun onLoad(isLoading: Boolean)
    }

    interface RegisterPresenter{
        fun userRegistration(user: User)
    }
}