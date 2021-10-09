package com.fgomes.mybusinesscard.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fgomes.mybusinesscard.domain.usecase.GetAllCardsUsecases
import kotlinx.coroutines.launch

class BusinessCardListViewModel (
    private val getAllCardsUsecases: GetAllCardsUsecases
        ) : ViewModel() {

   /* fun insert(businessCard: BusinessCard){
        getAllCardsUsecases.insert(businessCard)
    }*/

    fun getAll() = viewModelScope.launch {
        getAllCardsUsecases()
    }

    /*fun getAll(): LiveData<List<BusinessCard>> {

        return getAllCardsUsecases.invoke()
    }*/

    /*suspend fun delete(businessCard: BusinessCard){
        getAllCardsUsecases.delete(businessCard)
    }*/
}