package com.bignerdranch.android.myapplicationoncleanarchitecture.domain

import java.util.*

data class ProduktItem (
    val name: String,
    val count: Int,
    var enabled: Boolean,
    val id: UUID = UUID.randomUUID()
) {
}