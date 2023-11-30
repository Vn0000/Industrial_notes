package com.bignerdranch.android.industrialnotes.domain

import java.util.*

data class ProductItem(
    val name: String?,
    val concentration: String?,
    val dosage: String?,
    val description: String?,
    val id: UUID = UUID.randomUUID()
) {
}