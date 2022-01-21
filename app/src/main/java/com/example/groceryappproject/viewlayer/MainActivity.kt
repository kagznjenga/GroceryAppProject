package com.example.groceryappproject.viewlayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.groceryappproject.R
import com.example.groceryappproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            mainLoginButton.setOnClickListener{
                startActivity(Intent(baseContext, LoginActivity::class.java))
            }
            mainRegisterButton.setOnClickListener{
                startActivity(Intent(baseContext, RegisterActivity::class.java))
                finish()
            }
        }
    }
}