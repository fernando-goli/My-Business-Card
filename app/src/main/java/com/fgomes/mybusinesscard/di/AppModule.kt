package com.fgomes.mybusinesscard.di

import androidx.room.Room
import com.fgomes.mybusinesscard.data.AppDatabase
import com.fgomes.mybusinesscard.domain.repository.BusinessCardRepository
import com.fgomes.mybusinesscard.domain.repository.DatabaseDataSource
import com.fgomes.mybusinesscard.domain.usecase.CreateCardUseCase
import com.fgomes.mybusinesscard.domain.usecase.CreateCardUseCaseImpl
import com.fgomes.mybusinesscard.domain.usecase.GetAllCardsUseCaseImpl
import com.fgomes.mybusinesscard.domain.usecase.GetAllCardsUsecases
import com.fgomes.mybusinesscard.ui.home.BusinessCardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val db = module {
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
}

val repositoryModule = module {
    single<BusinessCardRepository> { DatabaseDataSource(businessCardDao = get()) }
}

val viewModelModule = module {
    viewModel { BusinessCardListViewModel(getAllCardsUsecases = get()) }
}

val domainModule = module {
    factory<GetAllCardsUsecases> { GetAllCardsUseCaseImpl(businessCardRepository = get()) }
    factory<CreateCardUseCase> { CreateCardUseCaseImpl(businessCardRepository = get()) }
    factory<GetAllCardsUsecases> { GetAllCardsUseCaseImpl(businessCardRepository = get()) }
    factory<GetAllCardsUsecases> { GetAllCardsUseCaseImpl(businessCardRepository = get()) }

}