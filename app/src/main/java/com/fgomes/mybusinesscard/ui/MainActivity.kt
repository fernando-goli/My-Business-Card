package com.fgomes.mybusinesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fgomes.mybusinesscard.R
import com.fgomes.mybusinesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateinit var

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }


}