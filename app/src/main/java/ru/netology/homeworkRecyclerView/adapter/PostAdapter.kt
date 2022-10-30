package ru.netology.homeworkRecyclerView.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import ru.netology.homeworkRecyclerView.DisplayingNumbers
import ru.netology.homeworkRecyclerView.R
import ru.netology.homeworkRecyclerView.databinding.CardPostBinding
import ru.netology.homeworkRecyclerView.dto.Post

class PostAdapter(
    private val likeClickListener: (Post) -> Unit,
    private val shareClickListener: (Post) -> Unit,
    private val viewClickListener: (Post) -> Unit
) : ListAdapter<Post, PostViewHolder>(PostDiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PostViewHolder(binding,
            likeClickListener, shareClickListener, viewClickListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }



}

