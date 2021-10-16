package com.fgomes.mybusinesscard.domain.usecase

import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository

class DeleteCardUseCase(
    private val businessCardRepository: BusinessCardRepository
) {
    suspend fun delete(id: Int) = businessCardRepository.delete(id)
}