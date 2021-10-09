package com.fgomes.mybusinesscard.ui.addCard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fgomes.mybusinesscard.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddBusinessCardFragment : Fragment() {

    private val viewModel: AddBusinessCardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_business_card_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    /*private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    /*private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository) }*/

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
    }*/

}