package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.data.Pokemon
import com.example.finalproject.data.Resource
import com.example.finalproject.data.Results

class ListPokemon_Adapter(private val pokeList: List<Results?>) :
    RecyclerView.Adapter<ListPokemon_Adapter.MyViewHolder>(){


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokeName: TextView
        val pokeURL: TextView

        init {
            pokeName = view.findViewById(R.id.name)
            pokeURL = view.findViewById(R.id.url)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_list_pokemon_adapter, viewGroup, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var item:Results = pokeList[position]!!
        holder.pokeName.text = item.name.toString()
        holder.pokeURL.text = item.url.toString()

        //holder.pokeName.text = item.results!!.name.toString()
        //holder.pokeURL.text = item.results!!.url.toString()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount():Int{
        return pokeList.size
    }
}