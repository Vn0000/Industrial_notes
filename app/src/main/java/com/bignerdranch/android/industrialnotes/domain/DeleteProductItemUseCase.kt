import com.bignerdranch.android.industrialnotes.domain.ProduсtItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository

class DeleteProductItemUseCase (private val productListRepository: ProductListRepository) {
    suspend fun deleteProductItem (produсtItem: ProduсtItem) {
        productListRepository.deleteProductItem(produсtItem)
    }
}