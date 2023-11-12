package com.bignerdranch.android.industrialnotes.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "produkt_items")
data class ProduktItemDbModel(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String,
    val count: Int,
    var enabled: Boolean
)