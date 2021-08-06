package com.example.studyactivitylifecyl.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.studyactivitylifecyl.Model.TestHero
import com.example.studyactivitylifecyl.R

class HeroesAdapter(context: Context, heroes: List<TestHero>): BaseAdapter() {
    private val context = context
    private val heroes = heroes

    override fun getCount(): Int {
        return heroes.count()
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

           // categoryView = LayoutInflater.from(context).inflate(R.layout.activity_heroes, null)
        val listheroView = LayoutInflater.from(context).inflate(R.layout.list_hero_view, parent, false)
           // val categoryImage: ImageView = categoryView.findViewById(R.id.heroesImageView)
            val heroText: TextView = listheroView.findViewById(R.id.textHeroView)
            val category = heroes[position]

            heroText.text = category.legends.all.toString()
            return listheroView

    }
}