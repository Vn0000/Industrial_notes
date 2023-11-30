import com.bignerdranch.android.industrialnotes.domain.ProductItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository


class EditProductItemUseCase (private val productListRepository: ProductListRepository) {
    suspend fun editProductItem(productItem: ProductItem) {
        productListRepository.editProductItem(productItem)
    }
}