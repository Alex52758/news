package com.example.exam15

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private val newsList: List<News>): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val newsContainer: RelativeLayout = itemView.findViewById(R.id.rl_newsItem)
        val newsLabel: TextView = itemView.findViewById(R.id.tv_newsLabel)
//        val newsText: TextView = itemView.findViewById(R.id.newsText)
        val newsDate: TextView = itemView.findViewById(R.id.tv_newsDate)
        val newsImage: ImageView = itemView.findViewById(R.id.iv_newsPhoto)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.newsLabel.text = currentItem.label
        holder.newsDate.text = currentItem.date.toString()
        holder.newsImage.setImageResource(currentItem.image)

        holder.newsContainer.setOnClickListener {
            val intentNewsPrev: Intent = Intent(holder.newsContainer.context, NewsItemActivity::class.java)
            intentNewsPrev.putExtra("label", currentItem.label)
            intentNewsPrev.putExtra("image", currentItem.image)
            intentNewsPrev.putExtra("text", currentItem.text)
            intentNewsPrev.putExtra("date", currentItem.date.toString())
            holder.newsContainer.context.startActivity(intentNewsPrev)
        }
    }

    override fun getItemCount(): Int = newsList.size
}