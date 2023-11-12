import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktListRepository


class EditProduktItemUseCase (private val produktListRepository: ProduktListRepository) {
    suspend fun editProduktItem(produktItem: ProduktItem) {
        produktListRepository.editProduktItem(produktItem)
    }
}