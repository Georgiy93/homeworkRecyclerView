package ru.netology.homeworkRecyclerView.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.netology.homeworkRecyclerView.dto.Post

class PostDiffCallback: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem==newItem
    }

}