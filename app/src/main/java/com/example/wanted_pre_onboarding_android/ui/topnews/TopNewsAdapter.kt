package com.example.wanted_pre_onboarding_android.ui.topnews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wanted_pre_onboarding_android.databinding.ItemNewsBinding
import com.example.wanted_pre_onboarding_android.model.Article

class TopNewsAdapter() :
    ListAdapter<Article, TopNewsAdapter.TopNewsViewHolder>(TopNewsDiffCallback()) {
    private lateinit var binding: ItemNewsBinding

    inner class TopNewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            Glide.with(itemView)
                .load(article.urlToImage)
                .into(binding.ivNewsImage)
            binding.tvNEwsTime.text = article.publishedAt
            binding.tvNewsAuthor.text = article.author
            binding.tvNewsTitle.text = article.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopNewsViewHolder {
        binding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopNewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class TopNewsDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.url == newItem.url
    }
}