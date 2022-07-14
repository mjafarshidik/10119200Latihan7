package com.penatabahasa.a10119200latihan7.ui.detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.penatabahasa.a10119200latihan7.base.BaseFragment
import com.penatabahasa.a10119200latihan7.databinding.FragmentDetailBinding
import com.penatabahasa.a10119200latihan7.model.detail.CoinDetail
import com.penatabahasa.a10119200latihan7.model.detail.DetailResponse
import com.penatabahasa.a10119200latihan7.utils.Constants.API_KEY
import com.penatabahasa.a10119200latihan7.utils.loadImage
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()


    override fun onCreateFinished() {
        viewModel.getDetail(API_KEY, args.symbol)
    }

    override fun initializeListeners() {}

    override fun observeEvents() {
        with(viewModel) {
            detailResponse.observe(viewLifecycleOwner) {
                parseData(it)
            }
            isLoading.observe(viewLifecycleOwner) {
                handleView(it)
            }
            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun parseData(it: DetailResponse?) {
        val gson = Gson()
        val json = gson.toJson(it?.data)
        val jsonObject = JSONObject(json)
        val jsonArray = jsonObject[args.symbol] as JSONArray

        val coin = gson.fromJson(jsonArray.getJSONObject(0).toString(), CoinDetail::class.java)

        coin?.let {
            with(binding) {
                ivDetail.loadImage(it.logo)
                tvDetailTitle.text = it.name
                tvDetailSymbol.text = it.symbol
                tvDetailDescription.text = it.description
            }
        }
    }

    private fun handleView(isLoading: Boolean = false) {
        binding.detailGroup.isVisible = !isLoading
        binding.pbDetail.isVisible = isLoading
    }
}