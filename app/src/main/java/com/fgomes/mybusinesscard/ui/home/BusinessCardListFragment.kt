package com.fgomes.mybusinesscard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fgomes.mybusinesscard.R
import com.fgomes.mybusinesscard.databinding.BusinessCardListFragmentBinding
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.util.Image
import com.fgomes.mybusinesscard.util.navigateWithAnimations
import org.koin.androidx.viewmodel.ext.android.viewModel

class BusinessCardListFragment : Fragment() {

    private var _binding: BusinessCardListFragmentBinding? = null
    private val binding:  BusinessCardListFragmentBinding get() = _binding!!

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

        observerVM()
        addNewCard()
    }

    private fun addNewCard(){
        binding.fab.setOnClickListener {
            findNavController().navigateWithAnimations(
                R.id.action_businessCardListFragment_to_addBusinessCardFragment)
        }
    }

    private fun observerVM() {
       binding.run {

           viewModel.getAll.observe(viewLifecycleOwner, { allCards ->

               val businessCardAdapter = BusinessCardAdapter(allCards).apply {
                   onItemClick = { businessCard ->
                       navigateToAddCardFragment(businessCard)
                   }

                   listenerShare = { card ->
                       Image.share(requireContext(), card)
                   }
               }

               with(binding.rvMain) {
                   setHasFixedSize(true)
                   adapter = businessCardAdapter
               }
           })
       }
    }

    private fun navigateToAddCardFragment(businessCard: BusinessCard){
        val direction = BusinessCardListFragmentDirections
            .actionBusinessCardListFragmentToAddBusinessCardFragment(businessCard)
        findNavController().navigateWithAnimations(direction)
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}