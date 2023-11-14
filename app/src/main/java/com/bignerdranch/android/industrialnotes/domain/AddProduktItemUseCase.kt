package com.bignerdranch.android.industrialnotes.domain


class AddProduktItemUseCase(private val produktListRepository: ProduktListRepository) {
    suspend fun addShopItem(produktItem: ProduktItem) {
        produktListRepository.addProduktItem(produktItem)
    }
}