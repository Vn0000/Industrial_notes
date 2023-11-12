package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

import androidx.lifecycle.LiveData

class GetProduktListUseCase (private val produktListRepository: ProduktListRepository) {
    fun getShopList(): LiveData<List<ProduktItem>> {
        return produktListRepository.getProduktList()
    }
}