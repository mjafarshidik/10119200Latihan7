package com.penatabahasa.a10119200latihan7.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.penatabahasa.a10119200latihan7.utils.loadImage

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class CoinBinding {

    companion object {
        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView: ImageView, coinImage: String) {
            val imageUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/$coinImage.png"
            imageView.loadImage(imageUrl)
        }
    }
}