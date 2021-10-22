package com.fgomes.mybusinesscard.ui.addCard

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.fgomes.mybusinesscard.R
import com.fgomes.mybusinesscard.databinding.AddBusinessCardFragmentBinding
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddBusinessCardFragment : Fragment() {

    private var _binding: AddBusinessCardFragmentBinding? = null
    private val binding: AddBusinessCardFragmentBinding get() = _binding!!
    private val viewModel: AddBusinessCardViewModel by viewModel()
    private val args: AddBusinessCardFragmentArgs by navArgs()

    private lateinit var name: String
    private lateinit var phone: String
    private lateinit var email: String
    private lateinit var business: String
    private lateinit var fundo: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddBusinessCardFragmentBinding.inflate(inflater, container, false)

        createUpdateCard()
        deleteCard()
        return binding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }*/

    private fun initFields() {
        binding.let { businessCard ->
            name = businessCard.tilName.editText?.text.toString()
            phone = businessCard.tilPhone.editText?.text.toString()
            business = businessCard.tilBusiness.editText?.text.toString()
            email = businessCard.tilEmail.editText?.text.toString()
            fundo = businessCard.tilCor.editText?.text.toString()
        }
    }

    private fun createUpdateCard() {
        if (args.businessCardArgs == null) {
            newCard()
        } else {
            binding.tvTitle.setText(R.string.update_card)
            updateCardGetArgs()
        }
    }

    private fun updateCardGetArgs() {
        args.businessCardArgs.let { businessCard ->
            binding.run {
                tilName.editText?.setText(businessCard?.name)
                tilEmail.editText?.setText(businessCard?.email)
                tilPhone.editText?.setText(businessCard?.phone)
                tilBusiness.editText?.setText(businessCard?.business)
                tilCor.editText?.setText(businessCard?.fundo)
                btRemoveBusinessCard.visibility = View.VISIBLE
                with(btAddUpdateBusinessCard) {
                    text = getString(R.string.update_card)
                    updateCard()
                }
            }
        }
    }

    private fun newCard() {
        binding.btAddUpdateBusinessCard.setOnClickListener {
            initFields()
            val businessCard = BusinessCard(0, name, phone, business, email, fundo)
            if (name.isNotBlank() && name.isNotEmpty()) {
                viewModel.insertCard(businessCard)
            }
            clearFields()
            findNavController().popBackStack()
        }
    }

    private fun updateCard() {
        binding.btAddUpdateBusinessCard.setOnClickListener {
            initFields()
            val businessCard =
                BusinessCard(args.businessCardArgs?.id ?: 0, name, phone, business, email, fundo)
            viewModel.updateCard(businessCard)
            clearFields()
            findNavController().popBackStack()
        }
    }

    private fun deleteCard() {
        binding.btRemoveBusinessCard.setOnClickListener {
            showRemoveDialog(args.businessCardArgs?.id ?: 0)
        }
    }

    private fun showRemoveDialog(id: Int) {
        AlertDialog.Builder(activity)
            .setTitle(getString(R.string.dialog_title_delete))
            .setMessage(getString(R.string.dialog_delete_msg))
            .setNegativeButton(getString(R.string.label_no), null)
            .setPositiveButton(getString(R.string.label_yes),
                DialogInterface.OnClickListener { _, _ ->
                    viewModel.deleteBusinesCard(id)
                    clearFields()
                    findNavController().popBackStack()
                })
            .create()
            .show()
    }

    private fun clearFields() {
        binding.tilName.editText?.text?.clear()
        binding.tilPhone.editText?.text?.clear()
        binding.tilBusiness.editText?.text?.clear()
        binding.tilEmail.editText?.text?.clear()
        binding.tilCor.editText?.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}