

import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktItem
import com.bignerdranch.android.myapplicationoncleanarchitecture.domain.ProduktListRepository
import java.util.UUID

class GetProduktItemUseCase (private val produktListRepository: ProduktListRepository)  {
    suspend fun getProduktItem(shopItemId: UUID): ProduktItem {
        return produktListRepository.getProduktItem(shopItemId)
    }
}