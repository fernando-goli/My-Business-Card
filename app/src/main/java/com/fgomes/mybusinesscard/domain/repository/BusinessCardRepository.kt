package com.fgomes.mybusinesscard.domain.repository

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.domain.model.BusinessCard

interface BusinessCardRepository{

    suspend fun insert(businessCard: BusinessCard)

    fun getAll(): LiveData<List<BusinessCard>>

    suspend fun delete(businessCard: BusinessCard)

    suspend fun update (businessCard: BusinessCard)

}