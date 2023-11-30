package com.bignerdranch.android.industrialnotes.presentation.listproduct

import DeleteProductItemUseCase
import EditProductItemUseCase
import GetProductListUseCase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.industrialnotes.domain.ProductItem
import com.bignerdranch.android.industrialnotes.data.ProductListRepositoryImpl
import kotlinx.coroutines.launch


class ProductListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProductListRepositoryImpl(application)

    private val getProductListUseCase = GetProductListUseCase(repository)
    private val deleteProductItemUseCase = DeleteProductItemUseCase(repository)
    private val editProductItemUseCase = EditProductItemUseCase(repository)

    val productList = getProductListUseCase.getProductList()



    fun deleteProductItem(productItem: ProductItem) {
        viewModelScope.launch { deleteProductItemUseCase.deleteProductItem(productItem) }
    }

    fun editProductItem(productItem: ProductItem) {
        viewModelScope.launch { editProductItemUseCase.editProductItem(productItem) }
    }

}