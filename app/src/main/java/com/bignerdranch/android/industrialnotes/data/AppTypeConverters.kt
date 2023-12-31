package com.bignerdranch.android.industrialnotes.data

import androidx.room.TypeConverter
import java.util.*

class AppTypeConverters {
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}