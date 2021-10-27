package com.example.apextracker.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentHomeBinding
import com.example.apextracker.view.activities.ProfileActivity
import com.example.apextracker.view.adapters.HeroesAdapter
import com.example.apextracker.viewmodel.HeroesViewModel

class HeroesFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    private lateinit var mAllInfoApex: HeroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            mBinding = FragmentHomeBinding.inflate(inflater, container, false)
            return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAllInfoApex = ViewModelProvider(this).get(HeroesViewModel::class.java)
        mAllInfoApex.getAllInfoApexFromAPI()

        mBinding.rvHeroList.layoutManager = GridLayoutManager(requireActivity(), 2)
        val heroesAdapter = HeroesAdapter(this@HeroesFragment)

        mBinding.rvHeroList.adapter = heroesAdapter



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