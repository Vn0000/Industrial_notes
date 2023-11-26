package com.bignerdranch.android.industrialnotes.presentation.listproduct

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import com.bignerdranch.android.industrialnotes.databinding.FragmentListProductBinding
import com.bignerdranch.android.industrialnotes.databinding.ItemProductBinding
import com.bignerdranch.android.industrialnotes.domain.ProductItem

class ProductListAdapter :
    ListAdapter<ProductItem, ProductItemViewHolder>(ProductItemDiffCalback()) {

    var onProductItemLongClickListener: ((ProductItem) -> Unit)? = null
    var onProductItemClickListener: ((ProductItem) -> Unit)? = null


    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        val binding = holder.binding
        getItem(position)?.let { holder.bind(it) }
        binding.root.setOnClickListener {
            Log.d("Click on item", "not et implemented")
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val binding =
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemViewHolder(binding)
    }

    companion object {
        const val MAX_POOL_SIZE = 15
    }
}