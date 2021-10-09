package com.fgomes.mybusinesscard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.mybusinesscard.R
import com.fgomes.mybusinesscard.databinding.BusinessCardListFragmentBinding
import com.fgomes.mybusinesscard.ui.adapter.BusinessCardAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BusinessCardListFragment : Fragment() {

    private var _binding: BusinessCardListFragmentBinding? = null
    private val binding:  BusinessCardListFragmentBinding get() = _binding!!
    private val adapter by lazy { BusinessCardAdapter() }

    private val viewModel: BusinessCardListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BusinessCardListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllBusinessCard()
        insertListeners()
    }

    private fun insertListeners(){
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_businessCardListFragment_to_addBusinessCardFragment)
        }

    }

    private fun getAllBusinessCard() {
        viewModel.getAll()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}