import com.bignerdranch.android.industrialnotes.domain.ProduсtItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository
import java.util.UUID

class GetProductItemUseCase (private val productListRepository: ProductListRepository)  {
    suspend fun getProductItem(shopItemId: UUID): ProduсtItem {
        return productListRepository.getProductItem(shopItemId)
    }
}