package com.fgomes.mybusinesscard.domain.repository

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.data.BusinessCardDAO
import com.fgomes.mybusinesscard.domain.model.BusinessCard

class BusinessCardRepository(
    private val businessCardDao: BusinessCardDAO
){

    fun getAllCards(): LiveData<List<BusinessCard>> = businessCardDao.getAll()
    suspend fun insert(businessCard: BusinessCard) = businessCardDao.insert(businessCard)
    suspend fun delete(id: Int) = businessCardDao.deleteById(id)
    suspend fun update (businessCard: BusinessCard) = businessCardDao.update(businessCard)

}