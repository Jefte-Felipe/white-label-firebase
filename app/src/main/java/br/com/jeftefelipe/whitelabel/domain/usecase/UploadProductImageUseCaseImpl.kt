package br.com.jeftefelipe.whitelabel.domain.usecase

import android.net.Uri
import br.com.jeftefelipe.whitelabel.data.ProductRepository
import javax.inject.Inject

class UploadProductImageUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : UploadProductImageUseCase {

    override suspend fun invoke(imageUri: Uri): String {
        return productRepository.uploadProductImage(imageUri)
    }
}
