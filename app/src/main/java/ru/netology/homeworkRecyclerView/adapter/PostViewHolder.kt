package ru.netology.homeworkRecyclerView.adapter

import androidx.recyclerview.widget.RecyclerView
import ru.netology.homeworkRecyclerView.DisplayingNumbers
import ru.netology.homeworkRecyclerView.R
import ru.netology.homeworkRecyclerView.databinding.CardPostBinding
import ru.netology.homeworkRecyclerView.dto.Post

class PostViewHolder(
    private val binding: CardPostBinding,
    private val likeClickListener: (Post) -> Unit,
    private val shareClickListener: (Post) -> Unit,
    private val viewClickListener: (Post) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content

            likes.setImageResource(
                if (post.likedByMe)
                    R.drawable.ic_baseline_favorite_24
                else R.drawable.ic_baseline_favorite_border_24
            )
            countView.text = DisplayingNumbers(post.view)
            countLikes.text = DisplayingNumbers(post.like)
            countShares.text = DisplayingNumbers(post.share)
            likes.setOnClickListener {
                likeClickListener(post)

            }
            share.setOnClickListener {
                shareClickListener(post)

            }

            view.setOnClickListener {
                viewClickListener(post)
            }


        }

    }
}