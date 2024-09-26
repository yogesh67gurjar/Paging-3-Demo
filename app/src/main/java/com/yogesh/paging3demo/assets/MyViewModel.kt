package com.yogesh.paging3demo.assets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.yogesh.paging3demo.data.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val apiService: ApiService) : ViewModel() {
    var products = Pager(
        config = PagingConfig(10),
        pagingSourceFactory = { MyPagingSource(apiService) }
    ).liveData.cachedIn(viewModelScope)
}