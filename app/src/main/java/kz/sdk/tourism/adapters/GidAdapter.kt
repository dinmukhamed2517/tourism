package kz.sdk.tourism.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.sdk.tourism.base.BaseGidViewHolder
import kz.sdk.tourism.databinding.ItemGidBinding
import kz.sdk.tourism.models.Gid

class GidAdapter:ListAdapter<Gid, BaseGidViewHolder<*>>(GidDiffUtils()){

    class GidDiffUtils():DiffUtil.ItemCallback<Gid>(){
        override fun areItemsTheSame(oldItem: Gid, newItem: Gid): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Gid, newItem: Gid): Boolean {
            return oldItem == newItem
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseGidViewHolder<*> {
        return GidViewHolder(
            ItemGidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseGidViewHolder<*>, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class GidViewHolder(binding:ItemGidBinding):BaseGidViewHolder<ItemGidBinding>(binding){
        override fun bindView(item: Gid) {
            with(binding){
                title.text = item.name
                imageView.setImageResource(item.img)
                price.text = item.price.toString()+" KZT"
                description.text = item.description
            }
        }

    }

}