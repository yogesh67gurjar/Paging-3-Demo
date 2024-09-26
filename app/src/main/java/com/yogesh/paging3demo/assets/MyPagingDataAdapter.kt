package com.yogesh.paging3demo.assets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yogesh.paging3demo.data.Product
import com.yogesh.paging3demo.databinding.RvProductsBinding


class MyPagingDataAdapter :
    PagingDataAdapter<Product, MyPagingDataAdapter.MyViewHolder>(diffUtil) {

    class MyViewHolder(val rvProductsBinding: RvProductsBinding) :
        RecyclerView.ViewHolder(rvProductsBinding.root)

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val single = getItem(position)
        single?.let {
            Picasso.get().load(single!!.images[0]).into(holder.rvProductsBinding.img)
            holder.rvProductsBinding.titleTv.text = single.title
            holder.rvProductsBinding.priceTv.text = "${single.price} $"
            holder.rvProductsBinding.categoryTv.text = single.category
            holder.rvProductsBinding.idTv.text = single.id.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RvProductsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}