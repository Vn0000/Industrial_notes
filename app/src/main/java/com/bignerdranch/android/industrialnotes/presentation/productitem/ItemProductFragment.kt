package com.bignerdranch.android.industrialnotes.presentation.productitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.industrialnotes.databinding.FragmentItemProductBinding
import com.bignerdranch.android.industrialnotes.presentation.model.ProductItemState
import java.util.*

class ItemProductFragment : Fragment() {

    private val args by navArgs<ItemProductFragmentArgs>()

    private var _binding: FragmentItemProductBinding? = null
    private val binding: FragmentItemProductBinding
        get() = _binding ?: throw RuntimeException("FragmentItemProductBinding == Null")

    private lateinit var viewModel: ProductItemViewModel



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ProductItemViewModel::class.java]
        launchRightMode()
    }

    private fun launchEditMode() {
        args.argsId?.let { viewModel.getProductItem(it) }
        viewModel.productItem.observe(viewLifecycleOwner){
            binding.tvDosage.setText(it.dosage)
            binding.tvConcentration.setText(it.concentration)
            binding.tvDistinctive.setText(it.description)
            binding.tvProdictName.setText(it.name)
        }
        binding.saveButton.setOnClickListener {
            viewModel.editProductItem(
                binding.tvProdictName.text?.toString(),
                binding.tvDistinctive.text?.toString(),
                binding.tvDosage.text?.toString(),
                binding.tvConcentration.text.toString()
            )
        }
    }
    private fun launchADDMode() {
        binding.saveButton.setOnClickListener {
            viewModel.addProductItem(
                binding.tvProdictName.text?.toString(),
                binding.tvConcentration.text?.toString(),
                binding.tvDosage.text?.toString(),
                binding.tvDistinctive.text?.toString()
            )
            findNavController().popBackStack()
        }
    }

    private fun  launchRightMode() {
        when (args.argsState) {
            ProductItemState.EDIT_MODE -> launchEditMode()
            ProductItemState.ADD_MODE -> launchADDMode()
        }
    }
}