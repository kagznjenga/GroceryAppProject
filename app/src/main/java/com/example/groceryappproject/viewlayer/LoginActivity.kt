package com.example.groceryappproject.viewlayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.ActivityLoginBinding
import com.example.groceryappproject.datalayer.remote.MyRequestHandler
import com.example.groceryappproject.presenterlayer.LoginMVP
import com.example.groceryappproject.presenterlayer.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginMVP.LoginView {
    lateinit var binding: ActivityLoginBinding
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginLoading.visibility = View.GONE
        val requestHandler = MyRequestHandler(this)
        presenter = LoginPresenter(requestHandler, this)
        loginEvent()
    }

    private fun loginEvent() {
        binding.apply {
            loginButton.setOnClickListener {
                presenter.loginUser(loginEmailEt.text.toString(), loginPasswordEt.text.toString())

            }
        }
    }

    override fun setResult(message: String) {
        if (message.equals("Login successful")){
            binding.loginLoading.visibility = View.GONE
            startActivity(Intent(baseContext, HomeActivity::class.java))
        }
    }

    override fun onLoad(isLoading: Boolean) {
        if (isLoading){
            binding.loginLoading.visibility = View.VISIBLE
        }
        else{
            binding.loginLoading.visibility = View.GONE
        }
    }
}