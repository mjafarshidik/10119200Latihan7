package com.penatabahasa.a10119200latihan7.utils

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import coil.load

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

fun ImageView.loadImage(url: String?) {
    val placeholder = createPlaceHolder(this.context)
    this.load(url) {
        crossfade(true)
        crossfade(500)
        placeholder(placeholder)
    }
}

private fun createPlaceHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 12f
        centerRadius = 40f
        start()
    }
}