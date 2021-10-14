package com.fgomes.mybusinesscard.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fgomes.mybusinesscard.domain.model.BusinessCard

@Dao
interface BusinessCardDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(businessCard: BusinessCard)

    @Query("SELECT * FROM table_businesscard")
    fun getAll(): LiveData<List<BusinessCard>>

    @Query("DELETE FROM table_businesscard WHERE id =:id")
    suspend fun deleteById (id: Int)

    @Update
    suspend fun update(businessCard: BusinessCard)

    @Delete
    suspend fun delete(businessCard: BusinessCard)

}