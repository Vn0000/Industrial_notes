package com.bignerdranch.android.industrialnotes.domain

import java.util.*

data class ProduсtItem (
    val name: String,
    val concentration: Int,
    val dosage: Int,
    val description: String,
    val id: UUID = UUID.randomUUID()
) {
}