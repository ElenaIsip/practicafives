package com.example.practicpo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practicpo.activity.Post

class PostRepositoryInMemoryImpl : PostRepository {
    private var post = Post(
        id = 1,
        author = "БТПИТ. Университет интернет-профориентации",
        content = "Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. и httt./tgghfugv/ru Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. Привет это новый курс по программированию. и httt./tgghfugv/ru",
        published = "02 февраля 2022 в 18:00",
        likedByMe = false
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data
    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe)
        data.value = post
    }
}