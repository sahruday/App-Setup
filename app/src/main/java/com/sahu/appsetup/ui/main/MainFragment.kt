package com.sahu.appsetup.ui.main

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.sahu.appUtil.ui.BaseFragment
import com.sahu.appsetup.R
import com.sahu.appsetup.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by activityViewModels() //to get same view model else where.

    private lateinit var binding: MainFragmentBinding

    override fun init(savedInstanceState: Bundle?, binding: MainFragmentBinding) {
        this.binding = binding
        lifecycleScope.launchWhenResumed {
            viewModel.getLocalData().collect {
                binding.message.text = it.toString()
            }
        }
        viewModel.fetchData()
    }

}