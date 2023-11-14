package com.bignerdranch.android.industrialnotes.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.UUID

@Dao
interface ProduktListDao {

    @Query("SELECT * FROM produkt_items")
    fun getProduktList(): LiveData<List<ProduktItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSProduktItem(produktItemDbModel: ProduktItemDbModel)

    @Query("DELETE FROM produkt_items WHERE id=:produktItemId")
    suspend fun deleteProduktItem(produktItemId: UUID)

    @Query("SELECT * FROM produkt_items WHERE id=:produktItemId LIMIT 1")
    suspend fun getProduktItem(produktItemId: UUID): ProduktItemDbModel
}
