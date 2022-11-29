package br.com.jeftefelipe.whitelabel.domain.usecase

import android.net.Uri
import br.com.jeftefelipe.whitelabel.data.ProductRepository
import br.com.jeftefelipe.whitelabel.domain.model.Product
import java.util.*
import javax.inject.Inject

class CreateProductUseCaseImpl @Inject constructor(
    private val uploadProductImageUseCase: UploadProductImageUseCase,
    private val productRepository: ProductRepository
) : CreateProductUseCase {

    override suspend fun invoke(description: String, price: Double, imageUri: Uri): Product {
        return try {
            val imageUrl = uploadProductImageUseCase.invoke(imageUri)
            val product = Product(UUID.randomUUID().toString(), description, price, imageUrl)
            productRepository.createProduct(product)
        } catch (e: Exception) {
            throw e
        }
    }
}
