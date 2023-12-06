package com.bignerdranch.android.industrialnotes.presentation.listproduct

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.industrialnotes.R
import com.bignerdranch.android.industrialnotes.databinding.FragmentListProductBinding
import com.bignerdranch.android.industrialnotes.domain.ProductItem

class ListProductFragment : Fragment() {

    private lateinit var viewModel: ProductListViewModel
    private lateinit var  productListAdapter: ProductListAdapter

    private var _binding: FragmentListProductBinding? = null
    private val binding: FragmentListProductBinding
        get() = _binding ?: throw RuntimeException("FragmentListProductBinding == Null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[ProductListViewModel::class.java]
        viewModel.productList.observe(this){
            productListAdapter.submitList(it)
        }

        binding.buttonAddProductItem.setOnClickListener {
            launchFragmentProductItem()
        }

    }

    private fun setupRecyclerView() {
        with(binding.rvProductList) {
            productListAdapter = ProductListAdapter()
            adapter = productListAdapter
            productListAdapter.onProductItemClickListener = {
                launchWatchItemFragment(it)
            }
        }
        setupSwipeListener(binding.rvProductList)
    }

    private fun  setupSwipeListener(rvProductList: RecyclerView) {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = productListAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteProductItem(item)
            }

        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(rvProductList)
    }
    private fun launchFragmentProductItem() {
        findNavController().navigate(
            R.id.action_listProductFragment_to_itemProductFragment
        )
    }

    private fun launchWatchItemFragment(productItem: ProductItem) {
        findNavController().navigate(
            ListProductFragmentDirections.actionListProductFragmentToWatchOnlyProductItemFragment(productItem)
        )
    }


}