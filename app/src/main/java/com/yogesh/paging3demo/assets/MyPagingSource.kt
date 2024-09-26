package com.yogesh.paging3demo.assets

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.yogesh.paging3demo.data.ApiService
import com.yogesh.paging3demo.data.Product


class MyPagingSource(val apiService: ApiService) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        if (state.anchorPosition == null) {
            return null
        } else {
            val anchorPage = state.closestPageToPosition(state.anchorPosition!!)
            return if (anchorPage?.nextKey != null) {
                anchorPage.nextKey?.minus(1)
            } else if (anchorPage?.prevKey != null) {
                anchorPage.prevKey?.plus(1)
            } else {
                null
            }
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        try {
            val currentPage = params.key ?: 0
            val response = apiService.getProducts((currentPage) * 10, 10)
            return LoadResult.Page(
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (((currentPage + 1) * 10) > response.total) null else currentPage + 1,
                data = response.products
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}