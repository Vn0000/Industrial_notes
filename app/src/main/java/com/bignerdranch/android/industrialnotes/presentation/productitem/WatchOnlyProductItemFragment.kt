package com.bignerdranch.android.industrialnotes.presentation.productitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.industrialnotes.databinding.FragmentItemProductOnlyWatchBinding

class WatchOnlyProductItemFragment : Fragment() {

    private val args by navArgs<WatchOnlyProductItemFragmentArgs>()

    private var _binding: FragmentItemProductOnlyWatchBinding? = null
    private val binding: FragmentItemProductOnlyWatchBinding
        get() = _binding ?: throw RuntimeException("FragmentItemProductOnlyWatchBinding == Null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemProductOnlyWatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvConcentration.text = args.args.concentration
        binding.tvDosage.text = args.args.dosage
        binding.tvProdictName.text = args.args.name
        binding.tvDistinctive.text = args.args.description
    }
}