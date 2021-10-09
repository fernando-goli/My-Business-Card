package com.fgomes.mybusinesscard.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fgomes.mybusinesscard.domain.model.BusinessCard

@Database(entities = [BusinessCard::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun businessDao(): BusinessCardDAO

}