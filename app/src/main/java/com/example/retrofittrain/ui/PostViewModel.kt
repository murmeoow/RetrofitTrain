package com.example.retrofittrain.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofittrain.models.PostIListResponse
import com.example.retrofittrain.models.PostIListResponseItem
import com.example.retrofittrain.repository.PostsRepository
import kotlinx.coroutines.launch

class PostViewModel(private val repository: PostsRepository): ViewModel() {

    val myResponse : MutableLiveData<PostIListResponseItem> = MutableLiveData()

    fun getPost() = viewModelScope.launch {
        val response: PostIListResponseItem = repository.getPostsList()
        myResponse.value = response
    }

}