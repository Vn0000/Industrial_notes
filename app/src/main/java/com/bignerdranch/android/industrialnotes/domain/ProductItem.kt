package com.bignerdranch.android.industrialnotes.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class ProductItem(
    val name: String?,
    val concentration: String?,
    val dosage: String?,
    val description: String?,
    val id: UUID = UUID.randomUUID()
): Parcelable {
}