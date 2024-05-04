package kz.sdk.tourism.base


import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kz.sdk.tourism.models.Gid
import kz.sdk.tourism.models.Place
import kz.sdk.tourism.models.Product

abstract class BaseViewHolder<VB : ViewBinding, T>(protected open val binding: VB) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bindView(item: T)
}

abstract class BasePlaceViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, Place>(binding)

abstract class BaseProductViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, Product>(binding)

abstract class BaseGidViewHolder<VB : ViewBinding>(override val binding: VB) :
    BaseViewHolder<VB, Gid>(binding)



