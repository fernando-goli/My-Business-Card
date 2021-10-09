package com.fgomes.mybusinesscard.domain.usecase

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository

class CreateCardUseCaseImpl(
    private val businessCardRepository: BusinessCardRepository
) : CreateCardUseCase {

    override suspend fun invoke(): LiveData<List<BusinessCard>> {
        TODO("Not yet implemented")
    }

}