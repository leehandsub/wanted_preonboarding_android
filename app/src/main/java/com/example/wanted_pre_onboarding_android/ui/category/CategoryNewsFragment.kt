package com.example.wanted_pre_onboarding_android.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.wanted_pre_onboarding_android.databinding.FragmentCategoryNewsBinding
import com.example.wanted_pre_onboarding_android.ui.common.ViewModelFactory

class CategoryNewsFragment : Fragment() {
    private val viewModel: CategoryNewsViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentCategoryNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarCategoryNews.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }

        requireArguments().getString("category").let {
            binding.toolbarCategoryNews.title = "Category-" + it.toString()
            viewModel.loadCategory(it.toString())
            setCategoryNewsAdapter()
        }
    }

    private fun setCategoryNewsAdapter() {
        val categoryAdapter = CategoryNewsAdapter()
        binding.rvCategoryNews.adapter = categoryAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
        }
    }
}