package com.example.mvvmsample.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsample.databinding.ActivityLoginBinding
import com.example.mvvmsample.viewModel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.buttonFirst.setOnClickListener {
            if(loginViewModel.checkLogin(this,binding.ed1.text.toString(), binding.ed2.text.toString())){
                Toast.makeText(this,"Login Successfully", Toast.LENGTH_SHORT).show()
                nextScreen()
            }
        }
    }
    fun nextScreen(){
        intent = Intent(applicationContext, NextScreenActivity::class.java)
        intent.putExtra("email",binding.ed1.text.toString())
        intent.putExtra("password",binding.ed2.text.toString())
        startActivity(intent)
    }
}