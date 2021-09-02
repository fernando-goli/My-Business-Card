package com.fgomes.mybusinesscard.ui.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.fgomes.mybusinesscard.App
import com.fgomes.mybusinesscard.data.BusinessCard
import com.fgomes.mybusinesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                business = binding.tilBusiness.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundo = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.ibClose.setOnClickListener {
            finish()
        }
    }
}