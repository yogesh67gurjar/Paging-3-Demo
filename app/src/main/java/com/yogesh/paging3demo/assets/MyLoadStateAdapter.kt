package com.yogesh.paging3demo.assets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yogesh.paging3demo.databinding.LayoutLoadRetryErrorBinding

class MyLoadStateAdapter(var retry: () -> Unit) :
    LoadStateAdapter<MyLoadStateAdapter.FourPagingViewHolder>() {
    class FourPagingViewHolder(val layoutLoadRetryErrorBinding: LayoutLoadRetryErrorBinding) :
        RecyclerView.ViewHolder(layoutLoadRetryErrorBinding.root)

    override fun onBindViewHolder(holder: FourPagingViewHolder, loadState: LoadState) {
        holder.layoutLoadRetryErrorBinding.retryBtn.visibility =
            if (loadState is LoadState.Error) View.VISIBLE else View.GONE

        holder.layoutLoadRetryErrorBinding.progressBar.visibility =
            if (loadState is LoadState.Loading) View.VISIBLE else View.GONE

        holder.layoutLoadRetryErrorBinding.errorMessage.visibility =
            if (loadState is LoadState.Error) View.VISIBLE else View.GONE

        if (holder.layoutLoadRetryErrorBinding.errorMessage.visibility == View.VISIBLE) {
            holder.layoutLoadRetryErrorBinding.errorMessage.text =
                (loadState as LoadState.Error).error?.message
        }
        holder.layoutLoadRetryErrorBinding.retryBtn.setOnClickListener {
            retry()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): FourPagingViewHolder {
        return FourPagingViewHolder(
            LayoutLoadRetryErrorBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}