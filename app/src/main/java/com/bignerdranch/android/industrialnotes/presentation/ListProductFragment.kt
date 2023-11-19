package com.bignerdranch.android.industrialnotes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.industrialnotes.R
import com.bignerdranch.android.industrialnotes.databinding.FragmentListProductBinding

class ListProductFragment : Fragment() {

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
        binding.buttonAddProductItem.setOnClickListener {
            launchFragmentProductItem()
        }
    }

    private fun launchFragmentProductItem() {
        findNavController().navigate(
            R.id.action_listProductFragment_to_itemProductFragment
        )
    }
}