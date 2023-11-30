package com.bignerdranch.android.industrialnotes.domain

import androidx.lifecycle.LiveData
import java.util.*

interface ProductListRepository {
    suspend fun addProductItem(productItem: ProductItem)
    suspend fun deleteProductItem (productItem: ProductItem)
    suspend fun editProductItem(productItem: ProductItem)
    suspend fun getProductItem(shopItemId: UUID): ProductItem
    fun getProductList(): LiveData<List<ProductItem>>
}