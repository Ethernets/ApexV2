package com.example.studyactivitylifecyl.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studyactivitylifecyl.R

class HeroesRecyclerAdapter(val context: Context, var heroes: ArrayList<String>): RecyclerView.Adapter<HeroesRecyclerAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heroesName = itemView?.findViewById<TextView>(R.id.textHeroView)

        fun bindHeroes (heroName: String, context: Context){


            heroesName?.text = heroName
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
        return  Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder?.bindHeroes(heroes[position], context)

    }

    override fun getItemCount(): Int {
        return heroes.count()
    }
}