package ru.netology.homeworkRecyclerView.repository;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import ru.netology.homeworkRecyclerView.dto.Post

class PostRepositoryInMemoryImpl : PostRepository {

    private var posts = listOf(
        Post(

            id = 4,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Четвертый пост: Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            sharedByMe = false,
            viewedByMe = false,
            like = 3
        ),
        Post(

            id = 3,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Третий пост: Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            sharedByMe = false,
            viewedByMe = false,
            like = 2,
            share = 2,
            view = 2,
        ),
        Post(
            id = 2,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Второй пост: Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            sharedByMe = false,
            viewedByMe = false,
            like = 1,
            share = 1,
            view = 1,
        ),
        Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likedByMe = false,
            sharedByMe = false,
            viewedByMe = false
        )

    )
    private val data = MutableLiveData(posts)

    override fun get(): LiveData<List<Post>> = data
    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id == id) {
                it.copy(
                    likedByMe = !it.likedByMe,
                    like = if (it.likedByMe) it.like - 1 else it.like + 1
                )
            } else {
                it
            }
        }

        data.value = posts

    }

    override fun shareById(id: Long) {
        posts = posts.map {
            if (it.id == id) {
                it.copy(
                    sharedByMe = !it.sharedByMe,
                    share = it . share +10_000

                )
            } else {
                it
            }
        }
        data.value = posts

    }

    override fun viewById(id: Long) {
        posts = posts.map {
            if (it.id == id) {
                it.copy(
                    viewedByMe = !it.viewedByMe,
                    view = it.view +10_000
                )
            } else {
                it
            }
        }

        data.value = posts
    }
}