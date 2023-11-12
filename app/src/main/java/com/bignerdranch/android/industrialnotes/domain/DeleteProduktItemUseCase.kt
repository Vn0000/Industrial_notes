import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktItem
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktListRepository

class DeleteProduktItemUseCase (private val produktListRepository: ProduktListRepository) {
    suspend fun deleteProduktItem (produktItem: ProduktItem) {
        produktListRepository.deleteProduktItem(Produkt)
    }
}