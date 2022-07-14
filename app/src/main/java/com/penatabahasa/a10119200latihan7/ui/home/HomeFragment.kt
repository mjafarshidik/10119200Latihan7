package com.penatabahasa.a10119200latihan7.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.penatabahasa.a10119200latihan7.base.BaseFragment
import com.penatabahasa.a10119200latihan7.databinding.FragmentHomeBinding
import com.penatabahasa.a10119200latihan7.model.home.Data
import com.penatabahasa.a10119200latihan7.utils.Constants.API_KEY
import com.penatabahasa.a10119200latihan7.utils.Constants.LIMIT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate
) {
    override val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData(API_KEY, LIMIT)
    }

    override fun onCreateFinished() {
    }

    override fun initializeListeners() {

    }

    override fun observeEvents() {
        with(viewModel) {
            cryptoResponse.observe(viewLifecycleOwner) {
                it?.let {
                    it.data?.let { it1 -> setRecycler(it1) }
                }
            }
            isLoading.observe(viewLifecycleOwner) {
                handleViews(it)
            }

            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setRecycler(data: List<Data>) {
        val mAdapter = HomeRecyclerAdapter(object : ItemClickListener {
            override fun onItemClick(coin: Data) {
                if (coin.symbol != null) {
                    val navigation =
                        HomeFragmentDirections.actionHomeFragmentToDetailFragment(coin.symbol)
                    Navigation.findNavController(requireView()).navigate(navigation)
                }
            }
        })
        binding.rvHome.adapter = mAdapter
        mAdapter.setList(data)
    }

    private fun handleViews(isLoading: Boolean = false) {
        binding.rvHome.isVisible = !isLoading
        binding.pbHome.isVisible = isLoading
    }
}