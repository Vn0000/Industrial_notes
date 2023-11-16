package com.bignerdranch.android.industrialnotes.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.UUID

@Dao
interface ProductListDao {

    @Query("SELECT * FROM product_items")
    fun getProductList(): LiveData<List<ProductItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSProductItem(productItemDbModel: ProductItemDbModel)

    @Query("DELETE FROM product_items WHERE id=:productItemId")
    suspend fun deleteProductItem(productItemId: UUID)

    @Query("SELECT * FROM product_items WHERE id=:productItemId LIMIT 1")
    suspend fun getProductItem(productItemId: UUID): ProductItemDbModel
}
