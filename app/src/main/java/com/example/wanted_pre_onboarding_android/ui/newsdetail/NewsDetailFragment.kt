package com.example.wanted_pre_onboarding_android.ui.newsdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.wanted_pre_onboarding_android.R
import com.example.wanted_pre_onboarding_android.databinding.FragmentNewsDetailBinding
import com.example.wanted_pre_onboarding_android.model.Article
import com.example.wanted_pre_onboarding_android.ui.common.EventObserver
import com.example.wanted_pre_onboarding_android.ui.common.ViewModelFactory
import kotlinx.coroutines.launch

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
        viewModel.search.observe(viewLifecycleOwner){ list->
            if(list.size==0){
                binding.savedButton.setImageResource(R.drawable.ic_star_off)
            }
            else {
                binding.savedButton.setImageResource(R.drawable.ic_star_on)
            }
        }
        Log.e("detailArticle", detailArticle.toString())//예외상황 설정
        binding.savedButton.setOnClickListener {
            viewModel.search.observe(viewLifecycleOwner){ list->
                if(list.size==0){
                    viewModel.addSaved(detailArticle)
                }
                else {
                    viewModel.deleteSaved(detailArticle)
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
