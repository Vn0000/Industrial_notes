package com.bignerdranch.android.industrialnotes.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository
import com.bignerdranch.android.industrialnotes.domain.ProduсtItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class ProductRepositoryImpl(
    application: Application
) : ProductListRepository {

    private val coroutine = Dispatchers.IO

    private val productListDao = AppDatabase.getInstance(application).productListDao()
    val mapper = ProductListMapper()
    override suspend fun addProductItem(produсtItem: ProduсtItem) = withContext(coroutine) {
        productListDao.addSProductItem(mapper.mapEntityToDbModel(produсtItem))
    }

    override suspend fun deleteProductItem(produсtItem: ProduсtItem) = withContext(coroutine) {
        productListDao.deleteProductItem(produсtItem.id)
    }

    override suspend fun editProductItem(produсtItem: ProduсtItem) = withContext(coroutine) {
        productListDao.addSProductItem(mapper.mapEntityToDbModel(produсtItem))
    }

    override suspend fun getProductItem(shopItemId: UUID): ProduсtItem = withContext(coroutine) {
        val dbModel = productListDao.getProductItem(shopItemId)
        return@withContext mapper.mapDbModelToEntity(dbModel)
    }

    override fun getProductList(): LiveData<List<ProduсtItem>> =
        MediatorLiveData<kotlin.collections.List<ProduсtItem>>().apply {
            addSource(productListDao.getProductList()) {
                value = mapper.mapListDbModelToListEntity(it)
            }
        }
}