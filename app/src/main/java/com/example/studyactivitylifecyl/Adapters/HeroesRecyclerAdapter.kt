package com.example.studyactivitylifecyl.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studyactivitylifecyl.Model.PlayerPerformance
import com.example.studyactivitylifecyl.Model.TestList
import com.example.studyactivitylifecyl.R
import com.squareup.picasso.Picasso

//Add val itemClick: (String) -> Unit
class HeroesRecyclerAdapter(private val context: Context, var heroes: ArrayList<TestList>, private val itemClick : (TestList) -> Unit): RecyclerView.Adapter<HeroesRecyclerAdapter.Holder>() {

    inner class Holder(itemView: View, val itemClick: (TestList) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val heroesName = itemView?.findViewById<TextView>(R.id.textHeroView)
        val imageBanerHero = itemView.findViewById<ImageView>(R.id.imageBanerHero)

        fun bindHeroes (heroName: TestList){


            heroesName?.text = heroName.name
            Picasso.get().load(heroName.data.ImgAssets.banner).into(imageBanerHero)

            itemView.setOnClickListener { itemClick(heroName) }

           //heroesName?.text = hero.legends.all.keys.first()
           // for((key) in hero.legends.all){
          //      Log.d("HeroesActivity", key)
                //holder.heroesName?.text = key
         //       heroesName?.text = key

         //   }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_hero_view, parent, false)
        return  Holder(view, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.bindHeroes(heroes[position])

    }

    override fun getItemCount(): Int {
        return heroes.count()
    }
}