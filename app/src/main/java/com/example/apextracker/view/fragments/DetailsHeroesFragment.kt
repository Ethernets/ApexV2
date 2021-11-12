package com.example.apextracker.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.apextracker.R
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.model.entities.Heroes


class DetailsHeroesFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_heroes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args: DetailsHeroesFragmentArgs by navArgs()

        Log.i("Heroes Details",
            args.heroesDetails.data.data?.forEach { Log.i("Heroes Value", it.value.toString()) }.toString()
        )
    }
}