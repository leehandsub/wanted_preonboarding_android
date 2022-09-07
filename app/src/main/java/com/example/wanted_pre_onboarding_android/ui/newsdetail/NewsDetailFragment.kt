package com.example.wanted_pre_onboarding_android.ui.newsdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wanted_pre_onboarding_android.databinding.FragmentNewsDetailBinding
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.ui.common.EventObserver
import com.example.wanted_pre_onboarding_android.ui.common.ViewModelFactory

class NewsDetailFragment : Fragment() {
    private lateinit var binding: FragmentNewsDetailBinding
    private val viewModel: NewsDetailViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var detailArticle: Article
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        setNavigation()

        detailArticle = Article(
            title = requireArguments().getString("title").toString(),
            publishedAt = requireArguments().getString("publishedAt").toString(),
            author = requireArguments().getString("author").toString(),
            content = requireArguments().getString("content").toString(),
            urlToImage = requireArguments().getString("urlToImage").toString()
        )
        binding.article = detailArticle

        viewModel.searchSaved(detailArticle.urlToImage)
        viewModel.search.observe(viewLifecycleOwner) {
            binding.savedButton.isSelected = it.isNotEmpty()
        }
        binding.savedButton.setOnClickListener {
            viewModel.search.observe(viewLifecycleOwner) { list ->
                if (list.isEmpty()) {
                    viewModel.addSaved(detailArticle)
                    it.isSelected = true
                } else {
                    viewModel.deleteSaved(detailArticle)
                    it.isSelected = false
                }
            }
        }

        viewModel.addSavedEvent.observe(viewLifecycleOwner, EventObserver {

            //저장 눌럿을떄 이벤트
        })

    }

    private fun setNavigation() {
        binding.toolbarNewsDetail.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
