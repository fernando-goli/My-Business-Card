package com.fgomes.mybusinesscard.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCard(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String,
    val business: String,
    val email: String,
    val fundo: String
)