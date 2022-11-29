package br.com.jeftefelipe.whitelabel.data

import android.net.Uri
import br.com.jeftefelipe.whitelabel.domain.model.Product
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val dataSource: ProductDataSource
) {

    suspend fun getProduct(): List<Product> = dataSource.getProduct()

    suspend fun uploadProductImage(imageUri: Uri): String = dataSource.uploadProductImage(imageUri)

    suspend fun createProduct(product: Product): Product = dataSource.createProduct(product)
}
