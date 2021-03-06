package com.example.finalproject.view

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalproject.R
import com.example.finalproject.data.PokemonDetail
import com.example.finalproject.data.Results
import com.example.finalproject.network.RetrofitApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPokemonAdapter(private val pokeList: List<Results?>, private val context:Context) :
    RecyclerView.Adapter<ListPokemonAdapter.MyViewHolder>(){

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    class MyViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val pokeName: TextView = view.findViewById(R.id.name)
        val pokeImage: ImageView = view.findViewById(R.id.pokemonImage)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_list_pokemon_adapter, viewGroup, false)

        return MyViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item:Results = pokeList[position]!!
        holder.pokeName.text = item.name.toString()

        // remove "https://pokeapi.co/api/v2/" from the full URL
        val tmpUrl = item.url.toString().replace("https://pokeapi.co/api/v2/", "")

        // holder.pokeImage.setImageDrawable(null)

        // Call retrofit to get image to show on the list view
        val api = RetrofitApiFactory().getPokemonApi()
        api.getSpecificPokemon(tmpUrl).enqueue(object : Callback<PokemonDetail> {
            override fun onResponse(call: Call<PokemonDetail>, response: Response<PokemonDetail>) {
                Log.i("getImage", "onResponse()")

                // if retrofit success, "response" should have info of all pokemon
                if (response.isSuccessful) {
                    Glide.with(context)
                        .load(response.body()!!.sprites?.front_default)
                        .into(holder.pokeImage) }
            }

            override fun onFailure(call: Call<PokemonDetail>, t: Throwable) {
                Log.e("getImage", "onFailure()")
            }
        })

        // When any card is clicked
        holder.itemView.setOnClickListener{
            val intent = Intent(context, DetailPokemonActivity::class.java)
            intent.putExtra("tmpUrl", tmpUrl)
            context.startActivity(intent)
        }

    }

    override fun getItemCount():Int{
        return pokeList.size
    }
}