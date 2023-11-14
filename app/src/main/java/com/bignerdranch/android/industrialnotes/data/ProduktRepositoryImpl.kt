package com.bignerdranch.android.industrialnotes.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.bignerdranch.android.industrialnotes.domain.ProduktItem
import com.bignerdranch.android.industrialnotes.domain.ProduktListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class ProduktRepositoryImpl(
    application: Application
) : ProduktListRepository {

    private val coroutine = Dispatchers.IO

    private val produktListDao = AppDatabase.getInstance(application).produktListDao()
    val mapper = ProduktListMapper()
    override suspend fun addProduktItem(produktItem: ProduktItem) = withContext(coroutine) {
        produktListDao.addSProduktItem(mapper.mapEntityToDbModel(produktItem))
    }

    override suspend fun deleteProduktItem(produktItem: ProduktItem) = withContext(coroutine) {
        produktListDao.deleteProduktItem(produktItem.id)
    }

    override suspend fun editProduktItem(produktItem: ProduktItem) = withContext(coroutine) {
        produktListDao.addSProduktItem(mapper.mapEntityToDbModel(produktItem))
    }

    override suspend fun getProduktItem(shopItemId: UUID): ProduktItem = withContext(coroutine) {
        val dbModel = produktListDao.getProduktItem(shopItemId)
        return@withContext mapper.mapDbModelToEntity(dbModel)
    }

    override fun getProduktList(): LiveData<List<ProduktItem>> =
        MediatorLiveData<kotlin.collections.List<ProduktItem>>().apply {
            addSource(produktListDao.getProduktList()) {
                value = mapper.mapListDbModelToListEntity(it)
            }
        }
}