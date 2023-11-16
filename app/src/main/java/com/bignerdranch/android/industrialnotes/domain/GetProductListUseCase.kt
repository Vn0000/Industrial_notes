import androidx.lifecycle.LiveData
import com.bignerdranch.android.industrialnotes.domain.ProduсtItem
import com.bignerdranch.android.industrialnotes.domain.ProductListRepository

class GetProductListUseCase (private val productListRepository: ProductListRepository) {
    fun getShopList(): LiveData<List<ProduсtItem>> {
        return productListRepository.getProductList()
    }
}