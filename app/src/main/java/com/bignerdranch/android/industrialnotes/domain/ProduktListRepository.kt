package com.bignerdranch.android.industrialnotes.domain

import androidx.lifecycle.LiveData
import java.util.*

interface ProduktListRepository {
    suspend fun addProduktItem(produktItem: ProduktItem)
    suspend fun deleteProduktItem (produktItem: ProduktItem)
    suspend fun editProduktItem(produktItem: ProduktItem)
    suspend fun getProduktItem(shopItemId: UUID): ProduktItem
    fun getProduktList(): LiveData<List<ProduktItem>>
}