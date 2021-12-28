package com.example.apextracker.view.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apextracker.R
import com.example.apextracker.databinding.ItemVideosLayoutBinding
import com.example.apextracker.model.entities.youtube.AllVideo

class VideosAdapter(private val fragment: Fragment): RecyclerView.Adapter<VideosAdapter.ViewHolder>() {
    private var videos: List<AllVideo.Item> = listOf()

    class ViewHolder(view: ItemVideosLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val ivVideosImage = view.ivVideosImage
        val tvVideosTitle = view.tvVideosTitle

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemVideosLayoutBinding = ItemVideosLayoutBinding.inflate(
            LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videos[position]
        Glide.with(fragment)
            .load(video.snippet.thumbnails.high.url)
            .error(R.drawable.images_err)
            .into(holder.ivVideosImage)
       // video.snippet.thumbnails.high.url
        holder.tvVideosTitle.text = video.snippet.title
    }

    override fun getItemCount(): Int {
        return videos.size
    }

    fun videosList(list: List<AllVideo.Item>){
        videos = list
        Log.i("Apex LIST",  videos.toString())
        notifyDataSetChanged()
    }
}