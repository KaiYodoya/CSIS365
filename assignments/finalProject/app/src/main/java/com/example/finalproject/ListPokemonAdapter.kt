package com.example.finalproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.data.Resource
import com.example.finalproject.data.Results
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokemonAdapter(private val pokeList: List<Results?>, private val context:Context) :
    RecyclerView.Adapter<ListPokemonAdapter.MyViewHolder>(){


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokeName: TextView
        val pokeURL: TextView
        val pokeImage: ImageView

        init {
            pokeName = view.findViewById(R.id.name)
            pokeURL = view.findViewById(R.id.url)
            pokeImage = view.findViewById(R.id.pokemonImage)
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

        val tmpUrl = item.url.toString().replace("https://pokeapi.co/api/v2/", "")


        // Call retrofit to get image to show on the list view
        val imageService = PokeService.create()
        imageService.getPokemonImage(tmpUrl).enqueue(object : Callback<Resource> {
            override fun onResponse(call: Call<Resource>, response: Response<Resource>) {
                Log.i("getImage", "onResponse()")

                // if retrofit success, "response" should have info of all pokemon
                if (response.isSuccessful) {
                    Glide.with(context)
                        .load(response.body()!!.sprites?.front_default)
                        .into(holder.pokeImage)
                }
            }

            override fun onFailure(call: Call<Resource>, t: Throwable) {
                Log.e("getImage", "onFailure()")
            }
        })


    }

    override fun getItemCount():Int{
        return pokeList.size
    }
}