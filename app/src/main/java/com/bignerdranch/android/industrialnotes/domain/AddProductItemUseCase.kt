package com.bignerdranch.android.industrialnotes.domain


class AddProductItemUseCase(private val productListRepository: ProductListRepository) {
    suspend fun addShopItem(produсtItem: ProduсtItem) {
        productListRepository.addProductItem(produсtItem)
    }
}