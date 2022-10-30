package ru.netology.homeworkRecyclerView.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.homeworkRecyclerView.repository.PostRepository
import ru.netology.homeworkRecyclerView.repository.PostRepositoryInMemoryImpl

class PostViewModel : ViewModel() {

    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.get()
    fun likeById(id:Long) = repository.likeById(id)
    fun shareById(id:Long) = repository.shareById(id)
    fun viewById(id:Long) = repository.viewById(id)
}
