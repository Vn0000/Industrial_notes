package com.bignerdranch.android.industrialnotes.presentation.autorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.industrialnotes.R
import com.bignerdranch.android.industrialnotes.databinding.FragmentAuthorizationBinding

class AutorizationFragment : Fragment() {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding: FragmentAuthorizationBinding
        get() = _binding ?: throw RuntimeException("FragmentAuthorizationBinding == Null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonAuthorization.setOnClickListener {
            launchFragmentProductList()
        }
    }
    private fun launchFragmentProductList(){
        findNavController().navigate(
            R.id.action_autorizationFragment_to_listProductFragment
        )
    }
}