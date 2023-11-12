package com.bignerdranch.android.industrialnotes.domain

import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktItem
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktListRepository


class AddProduktItemUseCase(private val produktListRepository: ProduktListRepository) {
    suspend fun addShopItem(produktItem: ProduktItem) {
        produktListRepository.addProduktItem(ProduktItem)
    }
}