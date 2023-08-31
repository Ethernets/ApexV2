package com.example.apextracker.view.fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.apextracker.R
import com.example.apextracker.databinding.FragmentDetailsHeroesBinding
import com.example.apextracker.model.entities.apex.Heroes


class DetailsHeroesFragment : Fragment() {

    private var mBinding: FragmentDetailsHeroesBinding? = null

    private var mHeroesDetails : Heroes? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_share, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val type = "text/plain"
                val subject = "Checkout this heroes "
                var extraText = ""
                val shareWith = "Share with"

                mHeroesDetails?.let { values ->
                    val image = values.data.ImgAssets.icon
                    var heroesDetail = ""
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        heroesDetail = Html.fromHtml(
                            values.name,
                            Html.FROM_HTML_MODE_COMPACT
                        ).toString()
                    } else {
                        @Suppress("DEPRECATION")
                        heroesDetail = Html.fromHtml(values.name).toString()
                    }

                    extraText =
                        "$image \n" +
                                "\n Hero: ${values.name} \n" +
                                when {
                                    values.data.data.isNullOrEmpty() -> {
                                        "\n DATA NOT FOUND"
                                    }
                                    values.data.data.size >= 4 -> {
                                        if(values.name == "Horizon"){
                                            "\n ${values.data.data[0].name} - ${values.data.data[0].value} \n" +
                                                    "\n ${values.data.data[1].name} - ${values.data.data[1].value} \n" +
                                                    "\n ${values.data.data[2].name} - ${values.data.data[2].value} \n" +
                                                    "\n ${values.data.data[3].name} - ${values.data.data[3].value} \n"

                                        }else {
                                            "\n ${values.data.data[0].name} - ${values.data.data[0].value} \n" +
                                                    "\n ${values.data.data[3].name} - ${values.data.data[3].value} \n" +
                                                    "\n ${values.data.data[4].name} - ${values.data.data[4].value} \n" +
                                                    "\n ${values.data.data[5].name} - ${values.data.data[5].value} \n"
                                        }
                                        }
                                    values.data.data.size == 3 -> {
                                            "\n ${values.data.data[0].name} - ${values.data.data[0].value} \n" +
                                                    "\n ${values.data.data[1].name} - ${values.data.data[1].value} \n" +
                                                    "\n ${values.data.data[2].name} - ${values.data.data[2].value} \n"
                                        }
                                    values.data.data.size == 1 -> {
                                            "\n ${values.data.data[0].name} - ${values.data.data[0].value} \n"
                                        }
                                    else -> {"\n ERROR"}
                                }
                                //"\n data: ${it?.data?.data?.forEach {test -> test.name }}"
                }
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = type
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                intent.putExtra(Intent.EXTRA_TEXT, extraText)
                startActivity(Intent.createChooser(intent, shareWith))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailsHeroesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return mBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args: DetailsHeroesFragmentArgs by navArgs()
        mHeroesDetails = args.heroesDetails

        Glide.with(this)
            .load(args.heroesDetails.data.ImgAssets.banner)
            .error(R.drawable.error)
            .into(mBinding!!.ivHeroesDetails)

        mBinding!!.tvHeroesName.text = args.heroesDetails.name

        args.heroesDetails.data.let { values ->
            when {
                values.data.isNullOrEmpty() -> {
                    mBinding!!.tvDataName.text = "NOT DATA"

                    mBinding!!.tvDataName2.visibility = View.INVISIBLE
                    mBinding!!.tvDataName3.visibility = View.INVISIBLE
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE

                    Log.i("Heroes test", "test")
                }
                values.data.size >= 4 -> {
                    mBinding!!.tvDataName.visibility = View.VISIBLE
                    mBinding!!.tvDataName2.visibility = View.VISIBLE
                    mBinding!!.tvDataName3.visibility = View.VISIBLE
                    mBinding!!.tvDataName4.visibility = View.VISIBLE

                    if (args.heroesDetails.name == "Horizon") {
                        values.data[0].let {
                            mBinding!!.tvDataName.text = "${it.name}: ${it.value}"
                        }
                        values.data[1].let {
                            mBinding!!.tvDataName2.text = "${it.name}: ${it.value}"
                        }
                        values.data[2].let {
                            mBinding!!.tvDataName3.text = "${it.name}: ${it.value}"
                        }
                        values.data[3].let {
                            mBinding!!.tvDataName4.text = "${it.name}: ${it.value}"
                        }
                    } else {
                        values.data[0].let {
                            mBinding!!.tvDataName.text = "${it.name}: ${it.value}"
                        }
                        values.data[3].let {
                            mBinding!!.tvDataName2.text = "${it.name}: ${it.value}"
                        }
                        values.data[4].let {
                            mBinding!!.tvDataName3.text = "${it.name}: ${it.value}"
                        }
                        values.data[5].let {
                            mBinding!!.tvDataName4.text = "${it.name}: ${it.value}"
                        }
                    }
                }
                values.data.size == 3 -> {
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                    values.data[0].let {
                        mBinding!!.tvDataName.text = "${it.name}: ${it.value}"
                    }
                    values.data[1].let {
                        mBinding!!.tvDataName2.text = "${it.name}: ${it.value}"
                    }
                    values.data[2].let {
                        mBinding!!.tvDataName3.text = "${it.name}: ${it.value}"
                    }
                }
                values.data.size == 1 -> {
                    mBinding!!.tvDataName2.visibility = View.INVISIBLE
                    mBinding!!.tvDataName3.visibility = View.INVISIBLE
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                    values.data[0].let {
                        mBinding!!.tvDataName.text = "${it.name}: ${it.value}"
                    }

                }
                else -> {
                    mBinding!!.tvDataName.visibility = View.INVISIBLE
                    mBinding!!.tvDataName2.visibility = View.INVISIBLE
                    mBinding!!.tvDataName3.visibility = View.INVISIBLE
                    mBinding!!.tvDataName4.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}