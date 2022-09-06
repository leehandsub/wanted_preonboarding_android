package com.example.wanted_pre_onboarding_android.ui.saved

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wanted_pre_onboarding_android.databinding.ItemNewsBinding
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.ui.common.CommonViewModel

class SavedAdapter(private val viewModel: CommonViewModel) :
    ListAdapter<Article, SavedAdapter.SavedViewHolder>(SavedDiffCallback()) {
    private lateinit var binding: ItemNewsBinding

    inner class SavedViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.viewModel = viewModel
            binding.article = article
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SavedAdapter.SavedViewHolder {
        binding =
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SavedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SavedAdapter.SavedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class SavedDiffCallback : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.urlToImage == newItem.urlToImage
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.urlToImage == newItem.urlToImage
    }
}
