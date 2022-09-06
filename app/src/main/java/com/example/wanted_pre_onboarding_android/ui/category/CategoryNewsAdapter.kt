package com.example.wanted_pre_onboarding_android.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wanted_pre_onboarding_android.R
import com.example.wanted_pre_onboarding_android.databinding.ItemNewsBinding
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.ui.common.loadImageGlide

class CategoryNewsAdapter() :
    ListAdapter<Article, CategoryNewsAdapter.CategoryNewsViewHolder>(CategoryNewsDiffCallback()) {
    private lateinit var binding: ItemNewsBinding

    inner class CategoryNewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            loadImageGlide(binding.ivNewsImage, article.urlToImage)
            binding.tvNewsTime.text = article.publishedAt
            binding.tvNewsAuthor.text = article.author
            binding.tvNewsTitle.text = article.title
            binding.newsLayout.setOnClickListener {
                it.findNavController().navigate(
                    R.id.action_categoryNewsFragment_to_newsDetailFragment, bundleOf(
                        "title" to article.title,
                        "author" to article.author,
                        "urlToImage" to article.urlToImage,
                        "content" to article.content,
                        "publishedAt" to article.publishedAt,
                    )
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryNewsViewHolder {
        binding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryNewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CategoryNewsDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.url == newItem.url
    }
}
