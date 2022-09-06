package com.example.wanted_pre_onboarding_android.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wanted_pre_onboarding_android.databinding.ItemNewsBinding
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.ui.common.CommonViewModel

class CategoryNewsAdapter(private val viewModel: CommonViewModel) :
    ListAdapter<Article, CategoryNewsAdapter.CategoryNewsViewHolder>(CategoryNewsDiffCallback()) {
    private lateinit var binding: ItemNewsBinding

    inner class CategoryNewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.viewModel = viewModel
            binding.article = article
            binding.executePendingBindings()
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
        return oldItem.urlToImage == newItem.urlToImage
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.urlToImage == newItem.urlToImage
    }
}
