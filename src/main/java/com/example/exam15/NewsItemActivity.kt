package com.example.exam15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_item)

        val tv_text = findViewById<TextView>(R.id.tv_newsItem_text)
        val tv_label = findViewById<TextView>(R.id.iv_newsItem_label)
        val tv_date = findViewById<TextView>(R.id.tv_newsItem_date)
        val iv_image = findViewById<ImageView>(R.id.iv_newsItem_image)

        tv_text.text = intent.getStringExtra("text")
        tv_date.text = intent.getStringExtra("date")
        tv_label.text = intent.getStringExtra("label")
        val imageRes = intent.getIntExtra("image", 1)
        iv_image.setImageResource(imageRes)
    }
}