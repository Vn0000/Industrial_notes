import com.bignerdranch.android.industrialnotes.domain.ProductItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository
import java.util.UUID

class GetProductItemUseCase (private val productListRepository: ProductListRepository)  {
    suspend fun getProductItem(shopItemId: UUID): ProductItem {
        return productListRepository.getProductItem(shopItemId)
    }
}