package ru.netology.homeworkRecyclerView.repository;

import androidx.lifecycle.LiveData

import ru.netology.homeworkRecyclerView.dto.Post


interface PostRepository {
    fun get(): LiveData<List<Post>>
    fun likeById(id: Long)
    fun shareById(id: Long)
    fun viewById(id: Long)
}