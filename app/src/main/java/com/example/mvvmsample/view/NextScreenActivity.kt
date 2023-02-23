package com.example.mvvmsample.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmsample.databinding.ActivityNextBinding

class NextScreenActivity :AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textSimple.text = intent.getStringExtra("email")+"\n"+intent.getStringExtra("password")
    }

}
