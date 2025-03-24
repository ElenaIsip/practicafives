package com.example.practicpo.viewlmodel



import androidx.lifecycle.ViewModel
import com.example.practicpo.repository.PostRepository
import com.example.practicpo.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
}