package com.example.apextracker.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentFunnyVideosBinding
import com.example.apextracker.model.entities.youtube.AllVideo
import com.example.apextracker.model.entities.youtube.Item
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.view.adapters.VideosAdapter
import com.example.apextracker.viewmodel.FunnyVideosViewModel


class FunnyVideosFragment : Fragment() {

    private lateinit var funnyVideosViewModel: FunnyVideosViewModel

    private var mBinding: FragmentFunnyVideosBinding? = null

    private lateinit var mVideosAdapter: VideosAdapter

    val test = ArrayList<Item>()

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

        mBinding?.rvVideoList?.layoutManager = GridLayoutManager(requireActivity(), 1)

        mVideosAdapter = VideosAdapter(this@FunnyVideosFragment)

        mBinding?.rvVideoList?.adapter = mVideosAdapter

        infoYoutubeVideoObserver()
    }

    private fun infoYoutubeVideoObserver() {
        funnyVideosViewModel.loadInfoYoutubeVideoResponse.observe(viewLifecycleOwner) {
            mVideosAdapter.videosList(it.items)
        }
    }


    fun videoDetails(videos: Item){
        findNavController().navigate(FunnyVideosFragmentDirections.actionNavigationFunnyVideosToNavigationFunnyVideosDetails(videos))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
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