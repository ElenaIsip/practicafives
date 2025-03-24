package com.example.practicpo.repository

import androidx.lifecycle.LiveData
import com.example.practicpo.activity.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
}