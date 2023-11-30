import androidx.lifecycle.LiveData
import com.bignerdranch.android.industrialnotes.domain.ProductItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository

class GetProductListUseCase (private val productListRepository: ProductListRepository) {
    fun getProductList(): LiveData<List<ProductItem>> {
        return productListRepository.getProductList()
    }
}