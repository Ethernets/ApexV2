package com.example.apextracker.view.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apextracker.R
import com.example.apextracker.application.ApexTrackerApplication
import com.example.apextracker.databinding.FragmentHeroesBinding
import com.example.apextracker.model.entities.apex.AllHeroes
import com.example.apextracker.model.entities.apex.Heroes
import com.example.apextracker.model.entities.apex.Profile
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

    private val allAdapterListHero = ArrayList<Heroes>()

    private lateinit var testApex: AllHeroes.Global

    private var mProgressDialog: Dialog? = null


    companion object {
        fun newInstanceUsername(username: String): HeroesFragment {
            val heroesFragment = HeroesFragment()
            heroesFragment.arguments?.putString("username", username)
            Constants.API_PLAYER_VALUE = username
            return heroesFragment
        }

        fun newInstanceChkBxState(state: Boolean): HeroesFragment {
            val heroesFragment = HeroesFragment()
            heroesFragment.arguments?.putBoolean("state", state)
            Constants.CHECK_BOX_STATE = state
            return heroesFragment
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

    private fun showCustomProgressDialog() {
        mProgressDialog = Dialog(requireActivity())
        mProgressDialog?.let {
            it.setContentView(R.layout.dilog_custom_progress)
            it.show()
        }
    }

    private fun hideProgressDialog() {
        mProgressDialog?.dismiss()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAllInfoApex =
            ViewModelProvider(this).get(HeroesViewModel::class.java)

        mAllInfoApex.getAllInfoApexFromAPI(Constants.API_PLAYER_VALUE)

        mBinding?.rvHeroList?.layoutManager = GridLayoutManager(requireActivity(), 2)

        mHeroesAdapter = HeroesAdapter(this@HeroesFragment)

        mBinding?.rvHeroList?.adapter = mHeroesAdapter

        infoApexViewModelObserver()
    }


    private fun infoApexViewModelObserver() {
        mAllInfoApex.allInfoApexResponse.observe(viewLifecycleOwner)
        { allInfoApexResponse ->
            allInfoApexResponse?.let {
                allAdapterListHero.clear()
                Log.i("Apex Info", "$allInfoApexResponse")
                if(Constants.CHECK_BOX_STATE) {
                    val userInfo = Profile(
                        allInfoApexResponse.global.name,
                        allInfoApexResponse.global.avatar,
                        false
                    )
                    for ((key, value) in allInfoApexResponse.legends.all) {
                        allAdapterListHero.add(Heroes(key, value))
                    }
                    Log.i("Apex Info 2", mHeroesAdapter.toString())
                    mProfileViewModel.insert(userInfo)

                } else {
                    for ((key, value) in allInfoApexResponse.legends.all) {
                        allAdapterListHero.add(Heroes(key, value))
                    }

                }
                testApex = allInfoApexResponse.global

                mHeroesAdapter.heroesList(allAdapterListHero)

                setAllInfoApexResponseInUI(allInfoApexResponse)
            }
        }

        mAllInfoApex.allInfoApexLoadingError.observe(viewLifecycleOwner,
            { dataError ->
                dataError?.let {
                 /*   if(dataError) {
                        Toast.makeText(
                            requireActivity(),
                            "User not found",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(requireActivity(), AuthorizationActivity::class.java))


                    }*/
                    Log.i("Error Apex API", "$dataError")
                }
            })
        mAllInfoApex.loadAllInfoApex.observe(viewLifecycleOwner,
            { loadAllInfoApex ->
                loadAllInfoApex?.let {
                    Log.i("Apex Loading", "$loadAllInfoApex")
                    if(loadAllInfoApex) {
                        showCustomProgressDialog()
                    } else {
                        hideProgressDialog()
                    }
                }
            })
    }

    private fun setAllInfoApexResponseInUI(allInfoApex: AllHeroes.Heroes) {

        //.into(mBinding!!.)
        //mBinding!!

    }

    fun heroesDetails(legends: Heroes) {
        findNavController().navigate(HeroesFragmentDirections.actionAllHeroesToHeroesDetails(legends))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                //startActivity(Intent(requireActivity(), ProfileActivity::class.java).putExtra("name",1))
                startActivity(
                    Intent(requireActivity(), ProfileActivity::class.java)
                        .putExtra("profile", testApex)
                )
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}