package com.bignerdranch.android.industrialnotes.data

import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktItem


class ProduktListMapper {

    fun mapEntityToDbModel(produktItem: ProduktItem) = ProduktItemDbModel(
        id = produktItem.id,
        name = produktItem.name,
        count = produktItem.count,
        enabled = produktItem.enabled
    )

    fun mapDbModelToEntity(produkItemDbModel: ProduktItemDbModel) = ProduktItem(
        id = produkItemDbModel.id,
        name = produkItemDbModel.name,
        count = produkItemDbModel.count,
        enabled = produkItemDbModel.enabled
    )

    fun mapListDbModelToListEntity(list: List<ProduktItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}