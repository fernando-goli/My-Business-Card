package com.fgomes.mybusinesscard.ui.addCard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgomes.mybusinesscard.domain.model.BusinessCard
import com.fgomes.mybusinesscard.domain.usecase.CreateCardUseCase
import com.fgomes.mybusinesscard.domain.usecase.DeleteCardUseCase
import com.fgomes.mybusinesscard.domain.usecase.GetAllCardsUseCase
import com.fgomes.mybusinesscard.domain.usecase.UpdateCardUseCase
import kotlinx.coroutines.launch

class AddBusinessCardViewModel(
    private val getAllCardsUseCase: GetAllCardsUseCase,
    private val createCardUseCase: CreateCardUseCase,
    private val updateCardUseCase: UpdateCardUseCase,
    private val deleteCardUseCase: DeleteCardUseCase
) : ViewModel() {

    private val getAll = getAllCardsUseCase()
    val getAllCards: LiveData<List<BusinessCard>> get() = getAll

    fun insertCard(businessCard: BusinessCard) = viewModelScope.launch {
        createCardUseCase.createBusinessCard(businessCard)
    }

    fun updateCard(businessCard: BusinessCard) = viewModelScope.launch {
        updateCardUseCase.update(businessCard)
    }

    fun deleteBusinesCard(id: Int) = viewModelScope.launch {
        deleteCardUseCase.delete(id)
    }

}