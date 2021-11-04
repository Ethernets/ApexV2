package com.example.apextracker.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apextracker.R
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.FragmentHeroesBinding
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.model.entities.IProfileToActivity
import com.example.apextracker.model.entities.Profile
import com.example.apextracker.utils.Constants
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.view.adapters.HeroesAdapter
import com.example.apextracker.viewmodel.HeroesViewModel
import com.example.apextracker.viewmodel.ProfileViewModel
import com.example.apextracker.viewmodel.ProfileViewModelFactory
import java.util.*
import kotlin.collections.ArrayList

class HeroesFragment : Fragment() {

    private var mBinding: FragmentHeroesBinding? = null

    private lateinit var mAllInfoApex: HeroesViewModel

    private lateinit var mHeroesAdapter: HeroesAdapter

    private val allAdapterListHero = ArrayList<AllHeroes.AdapterListHero>()

    private lateinit var testApex: AllHeroes.Global


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

    private val mProfileViewModel: ProfileViewModel by viewModels {
        ProfileViewModelFactory((requireActivity().application as ApexTrackerApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
            mBinding = FragmentHeroesBinding.inflate(inflater, container, false)
            return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAllInfoApex =
            ViewModelProvider(this).get(HeroesViewModel::class.java)

        mAllInfoApex.getAllInfoApexFromAPI(Constants.API_PLAYER_VALUE)

        mBinding?.rvHeroList?.layoutManager = GridLayoutManager(requireActivity(), 2)

        mHeroesAdapter = HeroesAdapter(this@HeroesFragment)

        mBinding?.rvHeroList?.adapter = mHeroesAdapter

        InfoApexViewModelObserver()
    }


    private fun InfoApexViewModelObserver(){
        mAllInfoApex.allInfoApexResponse.observe(viewLifecycleOwner)
            {allInfoApexResponse ->
                allInfoApexResponse?.let {
                Log.i("Apex Info", "$allInfoApexResponse")
                if (Constants.CHECK_BOX_STATE){
                    val userInfo = Profile(
                        allInfoApexResponse.global.name,
                        allInfoApexResponse.global.avatar,
                        false
                    )
                    for ((key, value) in allInfoApexResponse.legends.all){
                        allAdapterListHero.add(AllHeroes.AdapterListHero(key,value))
                    }
                    Log.i("Apex Info 2", mHeroesAdapter.toString())
                    mProfileViewModel.insert(userInfo)

                }else{
                    for ((key, value) in allInfoApexResponse.legends.all){
                        allAdapterListHero.add(AllHeroes.AdapterListHero(key,value))
                    }

                }

                mHeroesAdapter.heroesList(allAdapterListHero)

                setAllInfoApexResponseInUI(allInfoApexResponse.global)
            }}

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

    private fun setAllInfoApexResponseInUI(allInfoApex: AllHeroes.Global){

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