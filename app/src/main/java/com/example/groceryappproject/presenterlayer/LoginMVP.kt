package com.example.groceryappproject.presenterlayer

class LoginMVP {
    interface LoginView{
        fun setResult(message: String)
        fun onLoad(isLoading: Boolean)
    }

    interface LoginPresenterMVP{
        fun loginUser(email: String, password: String)
    }
}