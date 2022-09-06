package com.example.wanted_pre_onboarding_android.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wanted_pre_onboarding_android.R
import com.example.wanted_pre_onboarding_android.databinding.ItemCatgoryBinding
import com.example.wanted_pre_onboarding_android.model.Category

class CategoryAdapter() :
    ListAdapter<Category, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {
    private lateinit var binding: ItemCatgoryBinding

    inner class CategoryViewHolder(var binding: ItemCatgoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            binding.apply {
                ivCategoryImage.setImageResource(category.image)
                tvCategoryName.text = category.name
                binding.categoryLayout.setOnClickListener {
                    it.findNavController().navigate(
                        R.id.action_navigation_category_to_categoryNewsFragment, bundleOf(
                            "category" to category.name
                        )
                    )
                }
                binding.executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CategoryAdapter.CategoryViewHolder {
        binding =
            ItemCatgoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }
}
