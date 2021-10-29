package com.example.apextracker.view.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.apextracker.R
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.FragmentHeroesBinding
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.view.adapters.HeroesAdapter
import com.example.apextracker.viewmodel.HeroesViewModel
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory

class HeroesFragment : Fragment() {

    private var mBinding: FragmentHeroesBinding? = null

    private lateinit var mAllInfoApex: HeroesViewModel

    private val mAllInfoApexViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((requireActivity().application as ApexTrackerApplication).repository)
       //FavDishViewModelFactory((requireActivity().application as FavDishApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            mBinding = FragmentHeroesBinding.inflate(inflater, container, false)
            return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val key = arguments?.getString("username", "")
        Log.i("PHONE BLYAT", key.toString())

        mAllInfoApex =
            ViewModelProvider(this).get(HeroesViewModel::class.java)

        mAllInfoApex.getAllInfoApexFromAPI("tot_sambiy")


        AllInfoApexViewModelObserver()
    }

    fun AllInfoApexViewModelObserver(){
        mAllInfoApex.allInfoApexResponse.observe(viewLifecycleOwner,
            {allInfoApexResponse -> allInfoApexResponse?.let {
                Log.i("Apex Info", "${allInfoApexResponse}")
            }}
        )
        mAllInfoApex.allInfoApexLoadingError.observe(viewLifecycleOwner,
            {
                dataError -> dataError?.let {
                    Log.i("Error Apex API", "$dataError")
            }
            })
        mAllInfoApex.loadAllInfoApex.observe(viewLifecycleOwner,
            {
                loadAllInfoApex -> loadAllInfoApex?.let {
                    Log.i("Apex Loading", "$loadAllInfoApex")
                }
            })
    }

    fun setAllInfoApexResponseInUI(allInfoApex: AllHeroes.Heroes){
        Glide.with(requireActivity())
            .load(allInfoApex.legends.all.Gibraltar.ImgAssets)
            .centerCrop()
            //.into(mBinding!!.)
        //mBinding!!

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile, menu)
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
        mBinding
    }
}