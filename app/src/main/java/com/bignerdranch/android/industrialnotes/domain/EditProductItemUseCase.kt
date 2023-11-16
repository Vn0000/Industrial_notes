import com.bignerdranch.android.industrialnotes.domain.ProduсtItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository


class EditProductItemUseCase (private val productListRepository: ProductListRepository) {
    suspend fun editProductItem(produсtItem: ProduсtItem) {
        productListRepository.editProductItem(produсtItem)
    }
}