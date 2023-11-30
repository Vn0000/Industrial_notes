import com.bignerdranch.android.industrialnotes.domain.ProductItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository

class DeleteProductItemUseCase (private val productListRepository: ProductListRepository) {
    suspend fun deleteProductItem (productItem: ProductItem) {
        productListRepository.deleteProductItem(productItem)
    }
}