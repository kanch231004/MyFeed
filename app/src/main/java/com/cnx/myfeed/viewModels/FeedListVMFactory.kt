package com.cnx.myfeed.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cnx.myfeed.data.FeedRepository

class FeedListVMFactory(
    private val repository: FeedRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = MyFeedViewModel(repository) as T
}