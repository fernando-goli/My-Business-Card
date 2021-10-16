package com.fgomes.mybusinesscard.domain.usecase

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository

class GetAllCardsUseCase(private val businessCardRepository: BusinessCardRepository) {

    operator fun invoke(): LiveData<List<BusinessCard>> = businessCardRepository.getAllCards()

}