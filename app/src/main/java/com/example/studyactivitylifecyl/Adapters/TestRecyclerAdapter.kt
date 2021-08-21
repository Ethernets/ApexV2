package com.example.studyactivitylifecyl.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studyactivitylifecyl.Model.AllLegends
import com.example.studyactivitylifecyl.Model.LegendWrapper
import com.example.studyactivitylifecyl.R

class TestRecyclerAdapter(val cont: Context): RecyclerView.Adapter<TestRecyclerAdapter.Holders>() {
    var heroes: List<AllLegends> = emptyList()

    inner class Holders(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heroesName = itemView?.findViewById<TextView>(R.id.textHeroView)

        fun bindHeroes (hero: AllLegends, context: Context){
            heroesName?.text = hero.all.keys.toString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holders {
        val view = LayoutInflater.from(cont).inflate(R.layout.list_hero_view, parent, false)
        return  Holders(view)
    }

    override fun onBindViewHolder(hold: Holders, position: Int) {
        hold?.bindHeroes(heroes[position], cont)
    }

    override fun getItemCount(): Int {
        return heroes.count()
    }

}