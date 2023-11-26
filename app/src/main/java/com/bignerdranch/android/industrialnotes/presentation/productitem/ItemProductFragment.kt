package com.bignerdranch.android.industrialnotes.presentation.productitem

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.bignerdranch.android.industrialnotes.databinding.FragmentItemProductBinding
import java.util.*

class ItemProductFragment: Fragment() {

    private var _binding: FragmentItemProductBinding? = null
    private val binding: FragmentItemProductBinding
        get() = _binding ?: throw RuntimeException("FragmentItemProductBinding == Null")

    private var screenMode: String = MODE_UNKNOWN
    private var  productItemId: UUID? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parsParam()
    }

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

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun parsParam() {
        val args = requireArguments()
        if (!args.containsKey(SCREEN_MODE)) {
            throw RuntimeException("Param screen mode is absent")
        }
        val mode = args.getString(SCREEN_MODE)
        if (mode != MODE_EDIT && mode != MODE_ADD) {
            throw RuntimeException("Unknown screen mode $mode")
        }
        screenMode = mode
        if (screenMode == MODE_EDIT) {
            if (!args.containsKey(SHOP_ITEM_ID)) {
                throw RuntimeException("Param shop item ID is absent")
            }
            productItemId = args.getSerializable(SHOP_ITEM_ID, UUID::class.java)
        }
    }
    companion object {
        private const val SCREEN_MODE = "extra_mod"
        private const val SHOP_ITEM_ID = "extra_shop_item_id"
        private const val MODE_EDIT = "edit_mod"
        private const val MODE_ADD = "add_mod"
        private const val MODE_UNKNOWN = ""
    }
}