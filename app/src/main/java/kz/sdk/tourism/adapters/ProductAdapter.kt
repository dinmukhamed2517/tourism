package kz.sdk.tourism.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sdk.tourism.base.BaseProductViewHolder
import kz.sdk.tourism.databinding.ItemProductBinding
import kz.sdk.tourism.models.Product

class ProductAdapter: ListAdapter<Product, BaseProductViewHolder<*>>(ProductDiffUtils()) {

    class ProductDiffUtils:DiffUtil.ItemCallback<Product>(){
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

    }

    var itemClick:((Product) ->Unit)? = null

    inner class ProductViewHolder(binding: ItemProductBinding):
        BaseProductViewHolder<ItemProductBinding>(binding){
        override fun bindView(item: Product) {
            with(binding){
                item.img?.let { imageView.setImageResource(it) }
                title.text = item.title
                price.text = item.price.toString()+" KZT"

            }
            itemView.setOnClickListener {
                itemClick?.invoke(item)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseProductViewHolder<*> {
       return ProductViewHolder(
           ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
       )
    }

    override fun onBindViewHolder(holder: BaseProductViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }
}
