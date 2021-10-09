package com.fgomes.mybusinesscard.domain.repository

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.data.BusinessCardDAO
import com.fgomes.mybusinesscard.domain.model.BusinessCard

class DatabaseDataSource(
    private val businessCardDao: BusinessCardDAO
) : BusinessCardRepository {

    override suspend fun insert(businessCard: BusinessCard) {
        businessCardDao.insert(businessCard)
    }

    override fun getAll(): LiveData<List<BusinessCard>> =
        businessCardDao.getAll()


    override suspend fun delete(businessCard: BusinessCard) {
        businessCardDao.delete(businessCard)
    }

    override suspend fun update(businessCard: BusinessCard) {
        businessCardDao.update(businessCard)
    }
}