package com.example.apextracker.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentFunnyVideosBinding
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.viewmodel.FunnyVideosViewModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.util.Util

class FunnyVideosFragment : Fragment() {

    private lateinit var funnyVideosViewModel: FunnyVideosViewModel

    private var mBinding: FragmentFunnyVideosBinding? = null

    private var playerExo: ExoPlayer? = null

    private var playWhenReady = true
    private var currentWindow = 0
    private var playBackPosition: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        funnyVideosViewModel =
            ViewModelProvider(this).get(FunnyVideosViewModel::class.java)

        mBinding = FragmentFunnyVideosBinding.inflate(inflater, container, false)
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        funnyVideosViewModel =
            ViewModelProvider(this).get(FunnyVideosViewModel::class.java)
        funnyVideosViewModel.getInfoYoutubeVideoFromAPI()

        infoYoutubeVideoObserver()
    }

    private fun infoYoutubeVideoObserver(){
        funnyVideosViewModel.loadInfoYoutubeVideoResponse.observe(viewLifecycleOwner){
            val urlTest = "https://www.youtube.com/watch?v=MFfXkKp6jok"
            val uriTest: Uri = Uri.parse(urlTest)

            initializePlayer(urlTest)
           // mBinding?.videoView?.setVideoURI(uriTest)
          //  mBinding?.videoView?.start()
            Log.i("Youtube", it.items.toString())
        }
    }

    private fun initializePlayer(videoUrl: String){
        playerExo = ExoPlayer.Builder(requireContext()).build()
        mBinding?.videoView?.player = playerExo

        object : YouTubeExtractor(requireContext()){
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                if(ytFiles != null){
                    val itag = 137 // Tag of video 1080p,
                    val audioTag = 140 // Tag of m4a audio
                    val youTubeUrl = ytFiles[itag].url
                    val audioUrl = ytFiles[audioTag].url

                    val audioSource: MediaSource = ProgressiveMediaSource
                        .Factory(DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(audioUrl))
                    val videoSource: MediaSource = ProgressiveMediaSource
                        .Factory(DefaultHttpDataSource.Factory())
                        .createMediaSource(MediaItem.fromUri(youTubeUrl))

                    playerExo?.setMediaSource(MergingMediaSource(
                        true, videoSource, audioSource
                    ), true)
                    playerExo?.prepare()
                    playerExo?.playWhenReady = playWhenReady
                    playerExo?.seekTo(currentWindow, playBackPosition)

                }
            }

        }.extract(videoUrl, false, true)




    }

    private fun releasePlayer(){
        if(playerExo != null){
            playWhenReady = playerExo!!.playWhenReady
            playBackPosition = playerExo!!.currentPosition
            currentWindow = playerExo!!.currentMediaItemIndex
            playerExo!!.release()
            playerExo = null
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer("https://www.youtube.com/watch?v=MFfXkKp6jok")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
     //   inflater.inflate(R.menu.menu_profile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_profile -> {
                startActivity(Intent(requireActivity(), ProfileActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}