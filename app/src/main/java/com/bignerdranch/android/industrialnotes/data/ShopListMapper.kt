package com.bignerdranch.android.industrialnotes.data

import com.bignerdranch.android.industrialnotes.domain.ProduktItem


class ProduktListMapper {

    fun mapEntityToDbModel(produktItem: ProduktItem) = ProduktItemDbModel(
        id = produktItem.id,
        name = produktItem.name,
        concentration = produktItem.concentration,
        description = produktItem.description,
        dosage = produktItem.dosage
    )

    fun mapDbModelToEntity(produkItemDbModel: ProduktItemDbModel) = ProduktItem(
        id = produkItemDbModel.id,
        name = produkItemDbModel.name,
        concentration = produkItemDbModel.concentration,
        description = produkItemDbModel.description,
        dosage = produkItemDbModel.dosage
    )

    fun mapListDbModelToListEntity(list: List<ProduktItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}