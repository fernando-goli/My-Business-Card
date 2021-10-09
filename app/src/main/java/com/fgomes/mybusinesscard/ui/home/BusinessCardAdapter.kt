package com.fgomes.mybusinesscard.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = { }
    var onItemClick: ( (entity: BusinessCard) -> Unit )? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root){

        private val tvName: TextView = binding.tvName
        private val tvEmail: TextView = binding.tvEmail
        private val tvNameBusiness: TextView = binding.tvNameBusiness
        private val tvPhone: TextView = binding.tvPhone

        fun bindView (item: BusinessCard){
            tvName.text = item.name
            tvEmail.text = item.email
            tvNameBusiness.text = item.business
            tvPhone.text = item.phone
            binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundo))
            binding.cdContent.setOnClickListener {
                listenerShare(it)
            }
            
        }
    }

}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id
}