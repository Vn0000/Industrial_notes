package com.bignerdranch.android.industrialnotes.presentation.productitem

import EditProductItemUseCase
import GetProductItemUseCase
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.industrialnotes.data.ProductListRepositoryImpl
import com.bignerdranch.android.industrialnotes.domain.AddProductItemUseCase
import com.bignerdranch.android.industrialnotes.domain.ProductItem
import kotlinx.coroutines.launch
import java.util.UUID

class ProductItemViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ProductListRepositoryImpl(application)

    private val getProductItemUseCase = GetProductItemUseCase(repository)
    private val addProductItemUseCase = AddProductItemUseCase(repository)
    private val editProductItemUseCase = EditProductItemUseCase(repository)

    private val _productItem = MutableLiveData<ProductItem>()
    val productItem: LiveData<ProductItem>
        get() = _productItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen


    fun getProductItem(productItemId: UUID) {
        viewModelScope.launch {
            val item = getProductItemUseCase.getProductItem(productItemId)
            _productItem.value = item
        }
    }

    fun addProductItem(
        name: String?,
        concentration: String?,
        dosage: String?,
        description: String?
    ) {
        viewModelScope.launch {
            val productItem = ProductItem(
                name,
                concentration,
                dosage,
                description
            )
            addProductItemUseCase.addShopItem(productItem)

        }
    }

    fun editProductItem(
        name: String?,
        concentration: String?,
        dosage: String?,
        description: String?
    ) {
        _productItem.value?.let {
            viewModelScope.launch {
                val item = it.copy(
                    name = name,
                    concentration = concentration,
                    dosage = dosage,
                    description = description
                )
                editProductItemUseCase.editProductItem(item)
            }
        }
    }
}