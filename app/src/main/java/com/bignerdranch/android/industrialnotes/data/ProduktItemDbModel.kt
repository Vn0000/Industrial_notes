package com.bignerdranch.android.industrialnotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "product_items")
data class ProductItemDbModel(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String,
    val concentration: String,
    val dosage: String,
    val description: String
)