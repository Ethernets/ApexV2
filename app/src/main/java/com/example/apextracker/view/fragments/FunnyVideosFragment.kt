package com.example.apextracker.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentFunnyVideosBinding
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.viewmodel.FunnyVideosViewModel


class FunnyVideosFragment : Fragment() {

    private lateinit var funnyVideosViewModel: FunnyVideosViewModel

    private var mBinding: FragmentFunnyVideosBinding? = null

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

            initializePlayer(urlTest)
           // mBinding?.videoView?.setVideoURI(uriTest)
          //  mBinding?.videoView?.start()
            Log.i("Youtube", it.items.toString())
        }
    }

    private fun initializePlayer(url: String) {

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