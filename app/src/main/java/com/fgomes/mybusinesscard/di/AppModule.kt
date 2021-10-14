package com.fgomes.mybusinesscard.di

import androidx.room.Room
import com.fgomes.mybusinesscard.data.AppDatabase
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository
import com.fgomes.mybusinesscard.domain.usecase.*
import com.fgomes.mybusinesscard.ui.addCard.AddBusinessCardViewModel
import com.fgomes.mybusinesscard.ui.home.BusinessCardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "businesscard_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single {
        get<AppDatabase>().businessDao()
    }

    single { BusinessCardRepository(businessCardDao = get()) }

    factory { GetAllCardsUseCase(businessCardRepository = get()) }
    factory { CreateCardUseCase(businessCardRepository = get()) }
    factory { UpdateCardUseCase(businessCardRepository = get()) }
    factory { DeleteCardUseCase(businessCardRepository = get()) }

    viewModel { BusinessCardListViewModel(get()) }
    viewModel { AddBusinessCardViewModel(get()) }
}