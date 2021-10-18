package com.example.studyactivitylifecyl.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.studyactivitylifecyl.model.TestHero
import com.example.studyactivitylifecyl.R



/*class HeroesAdapter(context: Context, heroes: ArrayList<TestHero>): BaseAdapter() {
    private val context = context
    private val heroes = heroes

    override fun getCount(): Int {
        return heroes.count()
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
     val listheroView : View
     val holder : ViewHolder

     if (convertView == null){

         listheroView = LayoutInflater.from(context).inflate(R.layout.list_hero_view, null)
         holder = ViewHolder()
         holder.heroesName = listheroView.findViewById(R.id.textHeroView)

         listheroView.tag = holder
         // val categoryImage: ImageView = categoryView.findViewById(R.id.heroesImageView)

     }else {
         holder = convertView.tag as ViewHolder
         listheroView = convertView
     }
        val heroes = heroes[position]
        //val heroes = getItem(position)
        holder.heroesName?.text = heroes.legends.all.keys.first()
       /* for((key) in heroes.legends.all){
            Log.d("HeroesActivity", key)
            //holder.heroesName?.text = key
            holder.heroesName?.text = key

        }*/

            return listheroView

    }

    private class ViewHolder {
        var heroesName : TextView? = null

    }
}
*/
/*class HeroesAdapter(context: Context, heroes: List<String>): BaseAdapter() {
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

        heroText.text = category

        return listheroView

    }
}*/
class HeroesAdapter(): BaseAdapter() {
    var heroes: List<TestHero> = emptyList()

    override fun getCount(): Int {
        return heroes.count()
    }

    override fun getItem(position: Int): Any {
        return heroes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(parent.context).inflate(R.layout.list_hero_view, parent, false)
        val heroText: TextView = view.findViewById(R.id.textHeroView)
        val hero = heroes[position]
        heroText.text = hero.legends.all.keys.first()
        return view
    }
}