package br.com.jeftefelipe.whitelabel.domain.usecase

import br.com.jeftefelipe.whitelabel.data.ProductRepository
import br.com.jeftefelipe.whitelabel.domain.model.Product
import javax.inject.Inject

class GetProductsUseCaseImp @Inject constructor(
    private val productRepository: ProductRepository
) : GetProductsUseCase {
    override suspend fun invoke(): List<Product> {
        return productRepository.getProduct()
    }
}
