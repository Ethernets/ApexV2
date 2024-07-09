package com.example.studyactivitylifecyl.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.studyactivitylifecyl.Model.TestHero
import com.example.studyactivitylifecyl.R

class PlayerInfAdapter(context: Context, playerInf: List<TestHero>): BaseAdapter() {
    val playerInf = playerInf
    val context = context

    override fun getCount(): Int {
        return playerInf.count()
    }

    override fun getItem(position: Int): Any {
        return playerInf[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val listInfPlaerView = LayoutInflater.from(context).inflate(R.layout.activity_heroes, parent, false)

        val infPlayerText: TextView = listInfPlaerView.findViewById(R.id.textNickname)
        val playerPosition = playerInf[position]

        infPlayerText.text = playerPosition.global.name

        return listInfPlaerView
    }
}