package com.alekseymakarov.multinews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alekseymakarov.multinews.R

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
    }
}