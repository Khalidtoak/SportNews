package com.example.sportnews.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.sportnews.R
import com.example.sportnews.datamodel.SportNews
import kotlinx.android.synthetic.main.sport_news_item.view.*
import retrofit2.Call

class NewsAdapter(private val context: Context, private var newsfetch:SportNews) :

//class NewsAdapter(private val context: Context,val newsfetch:SportNews) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
//private lateinit var sportnews:SportNews

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.sport_news_item,
            parent, false))
    }

    override fun getItemCount(): Int {
        return newsfetch.articles.size

         }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
       // var str:String = "Bode is thinking"
       // sportnews = listItems[position]
        val result = newsfetch.articles[position]
      //  var resu = listItems[position]
        val res = newsfetch.source[position]
        holder.itemView.news_title.text = result.title
     //   holder.itemView.news_source.text = res.name
     //   holder.itemView.news_date.text = sportnews.articles[position].publishedAt
        holder.itemView.news_source.text = res.name
       holder.itemView.news_date.text = result.publishedAt
        Glide.with(context).asBitmap().load(result.urlToImage)
            //.diskCacheStrategy(DiskCacheStrategy.NONE)
            //.placeholder(R.mipmap.newsicon)
            .into(holder.itemView.news_image)
            }
    inner class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
       //     val result = newsfetch.articles[adapterPosition]
        //    val intent = Intent(context, NewsDetailActivity::class.java).apply {
         //       putExtra("Title", result.title)
          //      putExtra("Description", result.overview)
           //     putExtra("imageUrl", "https://image.tmdb.org/t/p/w500${result.posterPath}")
            }
           // context.startActivity(intent)
        }
}
