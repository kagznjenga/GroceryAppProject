package com.example.groceryappproject.viewlayer

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.groceryappproject.databinding.ActivityRegisterBinding
import com.example.groceryappproject.datalayer.model.User
import com.example.groceryappproject.datalayer.remote.MyRequestHandler
import com.example.groceryappproject.presenterlayer.RegistrationMVP
import com.example.groceryappproject.presenterlayer.RegistrationPresenter

class RegisterActivity : AppCompatActivity(), RegistrationMVP.RegisterView {
    lateinit var binding: ActivityRegisterBinding
    lateinit var presenter: RegistrationPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerLoading.visibility = View.GONE
        val requestHandler = MyRequestHandler(this)
        presenter = RegistrationPresenter(requestHandler, this)

        registerEvent()
    }

    private fun registerEvent() {
        binding.apply {
            registerButton.setOnClickListener{
                val fullName =  firstNameEt.text.toString() + " " + lastNameEt.text.toString()
                presenter.userRegistration(User(fullName, mobileEt.text.toString(),
                    emailEt.text.toString(), passwordEt.text.toString()))
            }
        }
    }

    override fun setResult(message: String) {
        if (message.equals("User registered successfully")){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    override fun onLoad(isLoading: Boolean) {
        if (isLoading){
            binding.registerLoading.visibility = View.VISIBLE
        }
        else{
            binding.registerLoading.visibility = View.GONE
        }
    }
}