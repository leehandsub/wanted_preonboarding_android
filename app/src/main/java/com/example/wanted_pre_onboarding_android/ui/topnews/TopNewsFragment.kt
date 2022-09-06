package com.example.wanted_pre_onboarding_android.ui.topnews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.wanted_pre_onboarding_android.databinding.FragmentTopnewsBinding
import com.example.wanted_pre_onboarding_android.ui.common.ViewModelFactory

class TopNewsFragment : Fragment() {

    private val viewModel: TopNewsViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentTopnewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopnewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTopNewsAdapter()
        /*viewModel.openNewsEvent.observe(viewLifecycleOwner,EventObserver{
            openTopNewsDetail(it)
        })*/
    }

    private fun setTopNewsAdapter() {
        val articleAdapter = TopNewsAdapter()
        binding.rvTopNews.adapter = articleAdapter
        viewModel.items.observe(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
    }
}