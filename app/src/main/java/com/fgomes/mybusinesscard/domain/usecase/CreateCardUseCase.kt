package com.fgomes.mybusinesscard.domain.usecase

import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository

class CreateCardUseCase(
    private val businessCardRepository: BusinessCardRepository
) {

    suspend fun createBusinessCard(businessCard: BusinessCard){
        businessCardRepository.insert(businessCard)
    }
}