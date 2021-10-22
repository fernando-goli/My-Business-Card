package com.fgomes.mybusinesscard.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isNotEmpty
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.mybusinesscard.databinding.ItemBusinessCardBinding
import com.fgomes.mybusinesscard.domain.model.BusinessCard


class BusinessCardAdapter(
    private val businessCard: List<BusinessCard>
) : RecyclerView.Adapter<BusinessCardAdapter.SubscriberListViewHolder>() {

    var onItemClick: ((businessCard: BusinessCard) -> Unit)? = null
    var listenerShare: (View) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val itemBinding = ItemBusinessCardBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SubscriberListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(businessCard[position])
    }

    override fun getItemCount(): Int = businessCard.size

    inner class SubscriberListViewHolder(private val binding: ItemBusinessCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val tvName: TextView = binding.tvName
        private val tvEmail: TextView = binding.tvEmail
        private val tvNameBusiness: TextView = binding.tvNameBusiness
        private val tvPhone: TextView = binding.tvPhone

        fun bindView(item: BusinessCard) {

            tvName.text = item.name
            tvEmail.text = item.email
            tvNameBusiness.text = item.business
            tvPhone.text = item.phone

            binding.run {
                with(cdContent){
                    setCardBackgroundColor(Color.parseColor(item.fundo))
                    setOnClickListener {
                        if(cdContent.isNotEmpty()) onItemClick?.invoke(item)
                    }
                }

                with(ibShareCard) {
                    setOnClickListener {
                        if(cdContent.isNotEmpty()) listenerShare(cdContent)
                    }
                }
            }

        }

    }

}

