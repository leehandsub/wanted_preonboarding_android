package com.example.wanted_pre_onboarding_android.ui.topnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wanted_pre_onboarding_android.R
import com.example.wanted_pre_onboarding_android.databinding.FragmentTopnewsBinding
import com.example.wanted_pre_onboarding_android.ui.common.CommonViewModel
import com.example.wanted_pre_onboarding_android.ui.common.EventObserver
import com.example.wanted_pre_onboarding_android.ui.common.ViewModelFactory

class TopNewsFragment : Fragment() {

    private val viewModel: TopNewsViewModel by viewModels { ViewModelFactory(requireContext()) }
    private val common: CommonViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentTopnewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTopnewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTopNewsAdapter()
        common.openNewsEvent.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                R.id.action_navigation_top_news_to_newsDetailFragment, bundleOf(
                    "title" to it.title,
                    "author" to it.author,
                    "urlToImage" to it.urlToImage,
                    "content" to it.content,
                    "publishedAt" to it.publishedAt,
                    "like" to it.like
                )
            )
        })
    }

    private fun setTopNewsAdapter() {
        val articleAdapter = TopNewsAdapter(common)
        binding.rvTopNews.adapter = articleAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
    }
}