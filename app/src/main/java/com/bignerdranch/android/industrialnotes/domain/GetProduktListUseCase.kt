import androidx.lifecycle.LiveData
import com.bignerdranch.android.industrialnotes.domain.ProduktItem
import com.bignerdranch.android.industrialnotes.domain.ProduktListRepository

class GetProduktListUseCase (private val produktListRepository: ProduktListRepository) {
    fun getShopList(): LiveData<List<ProduktItem>> {
        return produktListRepository.getProduktList()
    }
}