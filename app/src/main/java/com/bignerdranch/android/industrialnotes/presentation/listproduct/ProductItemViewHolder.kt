package com.bignerdranch.android.industrialnotes.presentation.listproduct

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bignerdranch.android.industrialnotes.databinding.FragmentListProductBinding
import com.bignerdranch.android.industrialnotes.databinding.ItemProductBinding
import com.bignerdranch.android.industrialnotes.domain.ProductItem

class ProductItemViewHolder (
    val binding: ItemProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var productItem: ProductItem
    private val tvProductName: TextView = binding.tvProductName
    private val tvProductDosage: TextView = binding.tvProductDosage
    private val tvProductConcentration: TextView = binding.tvProductDosage

    fun bind(productItem: ProductItem) {
        this.productItem = productItem
        tvProductName.text = this.productItem.name
        tvProductConcentration.text = this.productItem.concentration
        tvProductDosage.text = this.productItem.dosage
    }

}