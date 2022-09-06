package com.example.wanted_pre_onboarding_android.ui.saved

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.wanted_pre_onboarding_android.R
import com.example.wanted_pre_onboarding_android.databinding.FragmentSavedBinding
import com.example.wanted_pre_onboarding_android.ui.common.CommonViewModel
import com.example.wanted_pre_onboarding_android.ui.common.EventObserver
import com.example.wanted_pre_onboarding_android.ui.common.ViewModelFactory

class SavedFragment : Fragment() {

    private val viewModel: SavedViewModel by viewModels { ViewModelFactory(requireContext()) }
    private lateinit var binding: FragmentSavedBinding
    private val common: CommonViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSavedAdapter()
        common.openNewsEvent.observe(viewLifecycleOwner, EventObserver {
            findNavController().navigate(
                R.id.action_navigation_saved_to_newsDetailFragment3, bundleOf(
                    "title" to it.title,
                    "author" to it.author,
                    "urlToImage" to it.urlToImage,
                    "content" to it.content,
                    "publishedAt" to it.publishedAt
                )
            )
        })
    }

    private fun setSavedAdapter() {
        val savedAdapter = SavedAdapter(common)
        binding.rvSavedNews.adapter = savedAdapter
        viewModel.saves.observe(viewLifecycleOwner) {
            savedAdapter.submitList(it)
            Log.e("savedAdapter", it.toString())//예외상황 설정
        }
    }
}