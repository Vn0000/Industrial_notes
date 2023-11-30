package com.bignerdranch.android.industrialnotes.presentation.listproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.industrialnotes.databinding.ItemProductBinding
import com.bignerdranch.android.industrialnotes.domain.ProductItem

class ProductListAdapter :
    ListAdapter<ProductItem, ProductListAdapter.ProductItemViewHolder>(ProductItemDiffCalback()) {

    var onProductItemLongClickListener: ((ProductItem) -> Unit)? = null
    var onProductItemClickListener: ((ProductItem) -> Unit)? = null


    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        return ProductItemViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class ProductItemViewHolder(binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var productItem: ProductItem
        private val tvProductName: TextView = binding.tvProductName
        private val tvProductDosage: TextView = binding.tvProductDosage
        private val tvProductConcentration: TextView = binding.tvProductConcentration

        fun bind(productItem: ProductItem) {
            this.productItem = productItem
            tvProductName.text = this.productItem.name
            tvProductConcentration.text = this.productItem.concentration
            tvProductDosage.text = this.productItem.dosage
        }
    }
}