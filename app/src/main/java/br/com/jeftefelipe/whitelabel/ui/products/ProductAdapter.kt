package br.com.jeftefelipe.whitelabel.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.jeftefelipe.whitelabel.databinding.ItemProductBinding
import br.com.jeftefelipe.whitelabel.domain.model.Product
import br.com.jeftefelipe.whitelabel.util.toCurrency
import com.bumptech.glide.Glide

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
       return ProductsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductsViewHolder(
        private val itemBinding: ItemProductBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(product: Product) {
            itemBinding.run {
                Glide.with(itemView)
                    .load(product.imageUrl)
                    .fitCenter()
                    .into(imageProduct)

                textDescription.text = product.description
                textPrice.text = product.price.toCurrency()
            }
        }

        companion object {
            fun create(parent: ViewGroup): ProductsViewHolder {
                val itemBinding = ItemProductBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return ProductsViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem == oldItem
            }
        }
    }
}