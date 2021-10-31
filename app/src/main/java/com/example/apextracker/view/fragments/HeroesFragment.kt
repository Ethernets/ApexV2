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
import com.example.apextracker.model.entities.Profile
import com.example.apextracker.utils.Constants
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.view.adapters.HeroesAdapter
import com.example.apextracker.viewmodel.HeroesViewModel
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory
import java.util.*

class HeroesFragment : Fragment() {

    private var mBinding: FragmentHeroesBinding? = null

    private lateinit var mAllInfoApex: HeroesViewModel

    private val mAllInfoApexViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((requireActivity().application as ApexTrackerApplication).repository)
       //FavDishViewModelFactory((requireActivity().application as FavDishApplication).repository)
    }

    companion object{
        fun newInstanceUsername(username: String): HeroesFragment{
            val heroesFragment = HeroesFragment()
            heroesFragment.arguments?.putString("username", username)
            Constants.API_PLAYER_VALUE = username
            return heroesFragment
        }

        fun newInstanceChkBxState(state: Boolean): HeroesFragment{
            val heroesFragment = HeroesFragment()
            heroesFragment.arguments?.putBoolean("state", state)
            Constants.CHECK_BOX_STATE = state
            return  heroesFragment
        }
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


        mAllInfoApex =
            ViewModelProvider(this).get(HeroesViewModel::class.java)

        //Log.i("Apex TEST API", Constants.API_PLAYER_VALUE)
        mAllInfoApex.getAllInfoApexFromAPI(Constants.API_PLAYER_VALUE)


        AllInfoApexViewModelObserver()
    }

    fun AllInfoApexViewModelObserver(){
        mAllInfoApex.allInfoApexResponse.observe(viewLifecycleOwner,
            {allInfoApexResponse -> allInfoApexResponse?.let {
                Log.i("Apex Info", "${allInfoApexResponse}")
                if (Constants.CHECK_BOX_STATE){
                    val userInfo = Profile(
                        allInfoApexResponse.global.name,
                        allInfoApexResponse.global.avatar,
                        allInfoApexResponse.global.rank.rankDiv,
                        allInfoApexResponse.global.rank.rankImg,
                        allInfoApexResponse.global.rank.rankName,
                        allInfoApexResponse.global.bans.isActive,
                        allInfoApexResponse.realtime.isOnline,
                        allInfoApexResponse.realtime.selectedLegend,
                        allInfoApexResponse.global.level
                    )
                    val mFavDishViewModel: ProfileViewModel by viewModels {
                       ProfileViewModelFactory((requireActivity().application as ApexTrackerApplication).repository)
                    }
                    Log.i("Apex Info User", userInfo.toString())
                    //mFavDishViewModel.insert(userInfo)

                }
                setAllInfoApexResponseInUI(allInfoApexResponse.global)
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

    fun setAllInfoApexResponseInUI(allInfoApex: AllHeroes.Global){

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