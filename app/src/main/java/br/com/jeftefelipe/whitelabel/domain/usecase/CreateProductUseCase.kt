package br.com.jeftefelipe.whitelabel.domain.usecase

import android.net.Uri
import br.com.jeftefelipe.whitelabel.domain.model.Product

interface CreateProductUseCase {

    suspend operator fun invoke(description: String, price: Double, imageUri: Uri): Product
}
