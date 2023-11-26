package com.bignerdranch.android.industrialnotes.presentation.listproduct

import androidx.recyclerview.widget.DiffUtil
import com.bignerdranch.android.industrialnotes.domain.ProductItem

class ProductItemDiffCalback: DiffUtil.ItemCallback<ProductItem>() {
    override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
        return oldItem == newItem
    }
}