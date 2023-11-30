package com.bignerdranch.android.industrialnotes.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository
import com.bignerdranch.android.industrialnotes.domain.ProductItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class ProductListRepositoryImpl(
    application: Application
) : ProductListRepository {

    private val coroutine = Dispatchers.IO

    private val productListDao = AppDatabase.getInstance(application).productListDao()
    private val mapper = ProductListMapper()
    override suspend fun addProductItem(productItem: ProductItem) = withContext(coroutine) {
        productListDao.addSProductItem(mapper.mapEntityToDbModel(productItem))
    }

    override suspend fun deleteProductItem(productItem: ProductItem) = withContext(coroutine) {
        productListDao.deleteProductItem(productItem.id)
    }

    override suspend fun editProductItem(productItem: ProductItem) = withContext(coroutine) {
        productListDao.addSProductItem(mapper.mapEntityToDbModel(productItem))
    }

    override suspend fun getProductItem(shopItemId: UUID): ProductItem = withContext(coroutine) {
        val dbModel = productListDao.getProductItem(shopItemId)
        return@withContext mapper.mapDbModelToEntity(dbModel)
    }

    override fun getProductList(): LiveData<List<ProductItem>> =
        MediatorLiveData<List<ProductItem>>().apply {
            addSource(productListDao.getProductList()) {
                value = mapper.mapListDbModelToListEntity(it)
            }
        }
}