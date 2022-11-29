package br.com.jeftefelipe.whitelabel.data

import android.net.Uri
import br.com.jeftefelipe.whitelabel.domain.model.Product

interface ProductDataSource {

    suspend fun getProduct(): List<Product>

    suspend fun uploadProductImage(imageUri: Uri): String

    suspend fun createProduct(product: Product): Product
}
