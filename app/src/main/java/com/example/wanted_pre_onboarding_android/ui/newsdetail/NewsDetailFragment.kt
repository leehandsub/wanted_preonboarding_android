package com.example.wanted_pre_onboarding_android.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wanted_pre_onboarding_android.databinding.FragmentNewsDetailBinding
import com.example.wanted_pre_onboarding_android.ui.common.loadImageGlide

class NewsDetailFragment : Fragment() {
    private lateinit var binding: FragmentNewsDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarNewsDetail.title = requireArguments().getString("title")
        binding.tvDetailTitle.text = requireArguments().getString("title")
        binding.tvDeatilTime.text = requireArguments().getString("publishedAt")
        binding.tvDeatilAuthor.text = requireArguments().getString("author")
        binding.tvDetailContent.text = requireArguments().getString("content")
        loadImageGlide(binding.ivDeatilImage, requireArguments().getString("urlToImage"))
        binding.toolbarNewsDetail.setNavigationOnClickListener {
            it.findNavController().navigateUp()
        }
    }
}
