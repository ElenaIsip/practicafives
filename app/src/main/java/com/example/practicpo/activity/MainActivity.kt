package com.example.practicpo.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.practicpo.R
import com.example.practicpo.databinding.ActivityMainBinding
import com.example.practicpo.databinding.ActivitymakBinding
import com.example.practicpo.viewlmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var likesCount = 0
    private var sharesCount = 0
    private var viewsCount = 0
    private var liked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                like.setImageResource(
                    if (post.likedByMe) R.drawable.heart else R.drawable.hert
                )
            }
        }
        binding.like.setOnClickListener {
            viewModel.like()
        }
        binding.like.setOnClickListener {
            liked = !liked
            if (liked) {
                likesCount++
                binding.like.setImageResource(R.drawable.heart)
            } else {
                likesCount--
                binding.like.setImageResource(R.drawable.hert)
            }
            binding.likesCount.text = formatCount(likesCount)
        }

        binding.share.setOnClickListener {
            sharesCount++
            binding.shareCount.text = formatCount(sharesCount)
        }

        viewsCount = 999999
        binding.viewCount.text = formatCount(viewsCount)
    }

    private fun formatCount(count: Int): String {
        return when {
            count >= 1_000_000 -> String.format("%.1fM", count.toDouble() / 1_000_000)
            count >= 1_000 -> String.format("%dK", count / 1_000)
            else -> count.toString()
        }
    }
}





