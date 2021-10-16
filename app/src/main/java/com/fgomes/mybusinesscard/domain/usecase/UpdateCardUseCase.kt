package com.fgomes.mybusinesscard.domain.usecase

import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository

class UpdateCardUseCase(
    private val businessCardRepository: BusinessCardRepository
) {
    suspend fun update (businessCard: BusinessCard) = businessCardRepository.update(businessCard)
}