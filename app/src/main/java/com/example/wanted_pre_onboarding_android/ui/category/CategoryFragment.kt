package com.example.wanted_pre_onboarding_android.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wanted_pre_onboarding_android.R
import com.example.wanted_pre_onboarding_android.databinding.FragmentCategoryBinding
import com.example.wanted_pre_onboarding_android.model.Category

class CategoryFragment : Fragment() {
    private lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var categoryList = arrayListOf<Category>()
        categoryList.add(Category("business", R.drawable.ic_tabler_businessplan))
        categoryList.add(Category("entertainment", R.drawable.ic_akar_icons_music))
        categoryList.add(Category("general", R.drawable.ic_akar_icons_people_group))
        categoryList.add(Category("health", R.drawable.ic_carbon_health_cross))
        categoryList.add(Category("science", R.drawable.ic_eos_icons_science_outlined))
        categoryList.add(Category("sports", R.drawable.ic_baseline_sports_soccer))
        categoryList.add(Category("technology", R.drawable.ic_mdi_robot_industrial_outline))
        val categoryAdapter = CategoryAdapter()
        binding.rvTopNews.adapter = categoryAdapter
        categoryAdapter.submitList(categoryList)
    }
}
