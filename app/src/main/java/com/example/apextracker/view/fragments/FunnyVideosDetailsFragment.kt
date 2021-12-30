package com.example.apextracker.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.apextracker.databinding.FragmentFunnyVideosDetailsBinding
import com.example.apextracker.model.entities.youtube.Item
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class FunnyVideosDetailsFragment : Fragment() {

    private lateinit var mBinding: FragmentFunnyVideosDetailsBinding
    private lateinit var mVideosItem: Item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFunnyVideosDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args: FunnyVideosDetailsFragmentArgs by navArgs()
        mVideosItem = args.videosDetailsArg
        val viewYoutubePlayer = mBinding.youtubePlayerView
        lifecycle.addObserver(viewYoutubePlayer)
        viewYoutubePlayer.addYouTubePlayerListener(object: AbstractYouTubePlayerListener(){

            override fun onReady(youTubePlayer: YouTubePlayer){
                youTubePlayer.loadVideo(mVideosItem.snippet.resourceId.videoId, 0F)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding.youtubePlayerView.release()
    }
}