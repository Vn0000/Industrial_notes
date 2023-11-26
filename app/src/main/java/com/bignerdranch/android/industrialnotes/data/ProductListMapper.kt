package com.bignerdranch.android.industrialnotes.data

import com.bignerdranch.android.industrialnotes.domain.ProductItem


class ProductListMapper {

    fun mapEntityToDbModel(productItem: ProductItem) = ProductItemDbModel(
        id = productItem.id,
        name = productItem.name,
        concentration = productItem.concentration,
        description = productItem.description,
        dosage = productItem.dosage
    )

    fun mapDbModelToEntity(producItemDbModel: ProductItemDbModel) = ProductItem(
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