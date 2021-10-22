package com.fgomes.mybusinesscard.ui.home

import androidx.lifecycle.ViewModel
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository

class BusinessCardListViewModel(
    private val repository: BusinessCardRepository
) : ViewModel() {

    val getAll = repository.getAllCards()

}