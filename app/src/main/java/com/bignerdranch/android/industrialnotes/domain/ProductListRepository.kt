package com.bignerdranch.android.industrialnotes.domain

import androidx.lifecycle.LiveData
import java.util.*

interface ProductListRepository {
    suspend fun addProductItem(produсtItem: ProduсtItem)
    suspend fun deleteProductItem (produсtItem: ProduсtItem)
    suspend fun editProductItem(produсtItem: ProduсtItem)
    suspend fun getProductItem(shopItemId: UUID): ProduсtItem
    fun getProductList(): LiveData<List<ProduсtItem>>
}