import com.bignerdranch.android.industrialnotes.domain.ProduktItem
import com.bignerdranch.android.industrialnotes.domain.ProduktListRepository

class DeleteProduktItemUseCase (private val produktListRepository: ProduktListRepository) {
    suspend fun deleteProduktItem (produktItem: ProduktItem) {
        produktListRepository.deleteProduktItem(produktItem)
    }
}