package com.alish.boilerplate.presentation.ui.fragments.home

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.R
import com.alish.boilerplate.databinding.FragmentHomeBinding
import com.alish.boilerplate.presentation.base.BaseFragment
import com.alish.boilerplate.presentation.ui.adapters.FooPagingAdapter
import com.alish.boilerplate.presentation.ui.adapters.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home
) {

    override val viewModel: HomeViewModel by viewModels()
    override val binding by viewBinding(FragmentHomeBinding::bind)

    private val fooAdapter = FooPagingAdapter()

    override fun initialize() {
        setupFooRecycler()
    }

    private fun setupFooRecycler() = with(binding) {
        recyclerHomeFoo.layoutManager = LinearLayoutManager(context)
        recyclerHomeFoo.adapter = fooAdapter.withLoadStateFooter(
            footer = CommonLoadStateAdapter { fooAdapter.retry() }
        )

        fooAdapter.addLoadStateListener { loadStates ->
            recyclerHomeFoo.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.loaderHome.isVisible = loadStates.refresh is LoadState.Loading
        }
    }

    override fun setupRequests() {
        fetchFoo()
    }

    private fun fetchFoo() {
        viewModel.fetchFoo().collectPaging {
            fooAdapter.submitData(it)
        }
    }
}