package com.example.apextracker.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apextracker.databinding.ItemHeroesLayoutBinding
import com.example.apextracker.model.entities.AllHeroes
import com.example.apextracker.model.entities.Heroes

class HeroesAdapter(private val fragment: Fragment): RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    private var heroes: List<AllHeroes.AdapterListHero> = listOf()
    private var heroesAll: List<AllHeroes.Heroes> = listOf()

    class ViewHolder(view: ItemHeroesLayoutBinding): RecyclerView.ViewHolder(view.root) {
        val ivHeroesImage = view.ivHeroesImage
        val tvTitle = view.tvHeroesTitle

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHeroesLayoutBinding = ItemHeroesLayoutBinding.inflate(
            LayoutInflater.from(fragment.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hero = heroes[position]
        Glide.with(fragment)
            .load(hero.data.ImgAssets.icon)
            .into(holder.ivHeroesImage)
            holder.tvTitle.text = hero.name

    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    fun heroesList(list: List<AllHeroes.AdapterListHero>){
        heroes = list
        notifyDataSetChanged()
    }

}