package com.bignerdranch.android.industrialnotes.precsentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bignerdranch.android.industrialnotes.databinding.FragmentItemProductBinding
import com.bignerdranch.android.industrialnotes.databinding.FragmentListProductBinding

class ItemProductFragment: Fragment() {

    private var _binding: FragmentItemProductBinding? = null
    private val binding: FragmentItemProductBinding
        get() = _binding ?: throw RuntimeException("FragmentItemProductBinding == Null")


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
    }

}