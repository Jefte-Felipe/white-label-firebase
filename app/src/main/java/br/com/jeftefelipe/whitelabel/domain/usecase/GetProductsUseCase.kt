package br.com.jeftefelipe.whitelabel.domain.usecase

import br.com.jeftefelipe.whitelabel.domain.model.Product

interface GetProductsUseCase {
    suspend operator fun invoke(): List<Product>
}
