package com.yogesh.paging3demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yogesh.paging3demo.assets.MyLoadStateAdapter
import com.yogesh.paging3demo.assets.MyPagingDataAdapter
import com.yogesh.paging3demo.assets.MyViewModel
import com.yogesh.paging3demo.databinding.ActivityOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OneActivity : AppCompatActivity() {
    private lateinit var activityOneBinding: ActivityOneBinding

    private lateinit var adapter: MyPagingDataAdapter
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityOneBinding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(activityOneBinding.root)

        initSetup()
        attachObserver()
        clickEvents()
    }

    private fun clickEvents() {
        activityOneBinding.refreshBtn.setOnClickListener {
            adapter.refresh()
        }
    }

    private fun attachObserver() {
        viewModel.products.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }

    private fun initSetup() {
        viewModel =
            ViewModelProvider(this@OneActivity)[MyViewModel::class.java]

        adapter = MyPagingDataAdapter()
        activityOneBinding.productsRecyclerView.adapter =
            adapter.withLoadStateHeaderAndFooter(
                header = MyLoadStateAdapter { adapter.retry() },
                footer = MyLoadStateAdapter { adapter.retry() }
            )
        activityOneBinding.productsRecyclerView.setHasFixedSize(true)
        activityOneBinding.productsRecyclerView.layoutManager =
            LinearLayoutManager(this@OneActivity)
    }
}