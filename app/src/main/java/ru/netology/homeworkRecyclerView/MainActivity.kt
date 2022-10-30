package ru.netology.homeworkRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.homeworkRecyclerView.adapter.PostAdapter

import ru.netology.homeworkRecyclerView.databinding.ActivityMainBinding

import ru.netology.homeworkRecyclerView.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostAdapter(
            { viewModel.likeById(it.id) },
            { viewModel.shareById(it.id) },
            { viewModel.viewById(it.id) })


        binding.posts.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)

        }
    }


}






