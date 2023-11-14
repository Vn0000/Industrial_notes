import com.bignerdranch.android.industrialnotes.domain.ProduktItem
import com.bignerdranch.android.industrialnotes.domain.ProduktListRepository


class EditProduktItemUseCase (private val produktListRepository: ProduktListRepository) {
    suspend fun editProduktItem(produktItem: ProduktItem) {
        produktListRepository.editProduktItem(produktItem)
    }
}