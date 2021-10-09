package com.fgomes.mybusinesscard.domain.usecase

import androidx.lifecycle.LiveData
import com.fgomes.mybusinesscard.domain.model.BusinessCard

interface GetAllCardsUsecases  {

    suspend operator fun invoke(): LiveData<List<BusinessCard>>

}