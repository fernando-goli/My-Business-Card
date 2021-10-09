package com.fgomes.mybusinesscard.domain.usecase

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository
import com.fgomes.mybusinesscard.domain.model.BusinessCard

class GetAllCardsUseCaseImpl(
    private val businessCardRepository: BusinessCardRepository
) : GetAllCardsUsecases {

    override suspend fun invoke(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }


}