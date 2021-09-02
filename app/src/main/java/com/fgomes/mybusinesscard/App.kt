package com.fgomes.mybusinesscard

import android.app.Application
import com.fgomes.mybusinesscard.data.AppDatabase
import com.fgomes.mybusinesscard.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}