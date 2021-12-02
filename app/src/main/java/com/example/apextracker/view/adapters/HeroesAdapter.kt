package com.example.apextracker.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apextracker.R
import com.example.apextracker.databinding.ItemHeroesLayoutBinding
import com.example.apextracker.model.entities.Heroes
import com.example.apextracker.view.fragments.HeroesFragment

class HeroesAdapter(private val fragment: Fragment): RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

    private var heroes: List<Heroes> = listOf() //List<AllHeroes.AdapterListHero> = listOf()

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
        /*
        if(hero.data.ImgAssets.icon.isEmpty()){
            Glide.with(fragment)
                .load(R.drawable.images_err)
                .error(R.drawable.images_err)
                .into(holder.ivHeroesImage)
        }else {*/
            Glide.with(fragment)
                .load(hero.data.ImgAssets.icon)
                .error(R.drawable.images_err)
                .into(holder.ivHeroesImage)
            holder.tvTitle.text = hero.name
       // }
        holder.itemView.setOnClickListener{
            if (fragment is HeroesFragment) {
                fragment.heroesDetails(hero)
            }

        }

    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    fun heroesList(list: List<Heroes>){//(list: List<AllHeroes.AdapterListHero>){
        heroes = list
        notifyDataSetChanged()
    }

}