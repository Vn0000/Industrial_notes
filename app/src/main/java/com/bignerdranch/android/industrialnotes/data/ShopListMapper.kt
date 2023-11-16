package com.bignerdranch.android.industrialnotes.data

import com.bignerdranch.android.industrialnotes.domain.ProduсtItem


class ProductListMapper {

    fun mapEntityToDbModel(produсtItem: ProduсtItem) = ProductItemDbModel(
        id = produсtItem.id,
        name = produсtItem.name,
        concentration = produсtItem.concentration,
        description = produсtItem.description,
        dosage = produсtItem.dosage
    )

    fun mapDbModelToEntity(producItemDbModel: ProductItemDbModel) = ProduсtItem(
        id = producItemDbModel.id,
        name = producItemDbModel.name,
        concentration = producItemDbModel.concentration,
        description = producItemDbModel.description,
        dosage = producItemDbModel.dosage
    )

    fun mapListDbModelToListEntity(list: List<ProductItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}