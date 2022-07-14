package com.penatabahasa.a10119200latihan7.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.penatabahasa.a10119200latihan7.R
import dagger.hilt.android.AndroidEntryPoint

/*
14 Juli 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}