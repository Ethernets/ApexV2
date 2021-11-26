package com.example.apextracker.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentDetailsHeroesBinding
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.model.entities.Heroes


class DetailsHeroesFragment : Fragment() {

    private var mBinding: FragmentDetailsHeroesBinding? = null

    //private val hero : ArrayList<AllHeroes.Data>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentDetailsHeroesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args: DetailsHeroesFragmentArgs by navArgs()

        Glide.with(this)
            .load(args.heroesDetails.data.ImgAssets.banner)
            .into(mBinding!!.ivHeroesDetails)

        mBinding!!.tvHeroesName.text = args.heroesDetails.name

        args.heroesDetails.data.let { values ->
            when {
                values.data.isNullOrEmpty() -> {
                    mBinding!!.tvDataName.text = "NOT DATA"

                    mBinding!!.tvDataValue.visibility = View.INVISIBLE
                    mBinding!!.tvDataName2.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue2.visibility = View.INVISIBLE
                    mBinding!!.tvDataName3.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue3.visibility = View.INVISIBLE
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue4.visibility = View.INVISIBLE

                    Log.i("Heroes test", "test")
                }
                values.data.size >= 4 -> {
                    mBinding!!.tvDataName4.visibility = View.VISIBLE
                    mBinding!!.tvDataValue4.visibility = View.VISIBLE

                    if (args.heroesDetails.name == "Horizon") {
                        values.data[0].let {
                            mBinding!!.tvDataName.text = it.name
                            mBinding!!.tvDataValue.text = it.value.toString()
                        }
                        values.data[1].let {
                            mBinding!!.tvDataName2.text = it.name
                            mBinding!!.tvDataValue2.text = it.value.toString()
                        }
                        values.data[2].let {
                            mBinding!!.tvDataName3.text = it.name
                            mBinding!!.tvDataValue3.text = it.value.toString()
                        }
                        values.data[3].let {
                            mBinding!!.tvDataName4.text = it.name
                            mBinding!!.tvDataValue4.text = it.value.toString()
                        }
                    } else {
                        values.data[0].let {
                            mBinding!!.tvDataName.text = it.name
                            mBinding!!.tvDataValue.text = it.value.toString()
                        }
                        values.data[3].let {
                            mBinding!!.tvDataName2.text = it.name
                            mBinding!!.tvDataValue2.text = it.value.toString()
                        }
                        values.data[4].let {
                            mBinding!!.tvDataName3.text = it.name
                            mBinding!!.tvDataValue3.text = it.value.toString()
                        }
                        values.data[5].let {
                            mBinding!!.tvDataName4.text = it.name
                            mBinding!!.tvDataValue4.text = it.value.toString()
                        }
                    }
                }
                values.data.size == 3 -> {
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue4.visibility = View.INVISIBLE
                    values.data[0].let {
                        mBinding!!.tvDataName.text = it.name
                        mBinding!!.tvDataValue.text = it.value.toString()
                    }
                    values.data[1].let {
                        mBinding!!.tvDataName2.text = it.name
                        mBinding!!.tvDataValue2.text = it.value.toString()
                    }
                    values.data[2].let {
                        mBinding!!.tvDataName3.text = it.name
                        mBinding!!.tvDataValue3.text = it.value.toString()
                    }
                }
                values.data.size == 1 -> {
                    mBinding!!.tvDataName2.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue2.visibility = View.INVISIBLE
                    mBinding!!.tvDataName3.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue3.visibility = View.INVISIBLE
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue4.visibility = View.INVISIBLE
                    values.data[0].let {
                        mBinding!!.tvDataName.text = it.name
                        mBinding!!.tvDataValue.text = it.value.toString()
                    }

                }
                else -> {
                    mBinding!!.tvDataName.visibility = View.INVISIBLE

                    mBinding!!.tvDataValue.visibility = View.INVISIBLE
                    mBinding!!.tvDataName2.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue2.visibility = View.INVISIBLE
                    mBinding!!.tvDataName3.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue3.visibility = View.INVISIBLE
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                    mBinding!!.tvDataValue4.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}