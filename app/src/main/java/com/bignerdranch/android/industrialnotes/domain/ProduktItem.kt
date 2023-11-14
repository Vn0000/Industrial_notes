package com.bignerdranch.android.industrialnotes.domain

import java.util.*

data class ProduktItem (
    val name: String,
    val concentration: Int,
    val dosage: Int,
    val description: Int,
    val id: UUID = UUID.randomUUID()
) {
}