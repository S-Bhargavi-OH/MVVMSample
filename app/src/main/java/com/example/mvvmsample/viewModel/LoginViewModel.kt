package com.example.mvvmsample.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.ViewModel


class LoginViewModel: ViewModel() {
    @SuppressLint("StaticFieldLeak")
    private var context : Context? = null
    fun checkLogin(context: Context, username:String, password:String): Boolean{
        this.context = context
        if (checkEmail(username,password)){
            return true
        } else{
            return false
        }
    }

    private fun checkEmail(username: String, password: String): Boolean {
        if (isValidEmail(username)){
            if (password.length>5){
                return true
            }else{
                Toast.makeText(context,"Password must be greater than 5",Toast.LENGTH_SHORT).show()
                return false
            }
        }else{
            Toast.makeText(context,"Check Email",Toast.LENGTH_SHORT).show()
            return false
        }
    }
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && target?.let { Patterns.EMAIL_ADDRESS.matcher(it).matches() } == true
    }

}