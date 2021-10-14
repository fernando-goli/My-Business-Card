package com.fgomes.mybusinesscard.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.databinding.ItemBusinessCardBinding
import com.google.android.material.card.MaterialCardView

/*class BusinessCardAdapter(
    private val card: List<BusinessCard>
) : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    //var listenerShare: (View) -> Unit = { }
    var onItemClick: ((entity: BusinessCard) -> Unit)? = null

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
    ) : RecyclerView.ViewHolder(binding.root) {

        private val tvName: TextView = binding.tvName
        private val tvEmail: TextView = binding.tvEmail
        private val tvNameBusiness: TextView = binding.tvNameBusiness
        private val tvPhone: TextView = binding.tvPhone

        fun bindView(item: BusinessCard) {
            tvName.text = item.name
            tvEmail.text = item.email
            tvNameBusiness.text = item.business
            tvPhone.text = item.phone
            binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundo))
            binding.cdContent.setOnClickListener {
                onItemClick?.invoke(item)
                //listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}*/

class BusinessCardAdapter (
    private val businessCard: List<BusinessCard>
): RecyclerView.Adapter<BusinessCardAdapter.SubscriberListViewHolder>() {

    var onItemClick: ( (entity: BusinessCard) -> Unit )? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val itemBinding = ItemBusinessCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubscriberListViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(businessCard[position])
    }

    override fun getItemCount(): Int = businessCard.size

    inner class SubscriberListViewHolder(private val binding: ItemBusinessCardBinding) :
        RecyclerView.ViewHolder(binding.root){

        private val tvName: TextView = binding.tvName
        private val tvEmail: TextView = binding.tvEmail
        private val tvNameBusiness: TextView = binding.tvNameBusiness
        private val tvPhone: TextView = binding.tvPhone

        fun bindView(item: BusinessCard ) {

                tvName.text = item.name
                tvEmail.text = item.email
                tvNameBusiness.text = item.business
                tvPhone.text = item.phone
                binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundo))
                binding.cdContent.setOnClickListener {
                    onItemClick?.invoke(item)
                    //listenerShare(it)

            }
        }

    }
}