package com.csis365.assignment1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListFruitAdapter(private val itemList: List<Fruit>, val context: Context) :
    RecyclerView.Adapter<ListFruitAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_list_fruit, viewGroup, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ListFruitAdapter.ViewHolder, position: Int) {
        val tmpItem:Fruit = itemList[position]
        holder.itemName.text = tmpItem.name.toString()
        holder.itemGenus.text = tmpItem.genus.toString()
        holder.itemOrder.text = tmpItem.order.toString()

        holder.itemView.setOnClickListener {
            var genus: String? = tmpItem.genus
            var name: String? = tmpItem.name
            var id: Int? = tmpItem.id
            var family: String? = tmpItem.family
            var order: String? = tmpItem.order

            var carbohydrates: Double? = tmpItem.nutritions!!.carbohydrates
            var protein: Double? = tmpItem.nutritions!!.protein
            var fat: Double? = tmpItem.nutritions!!.fat
            var calories: Double? = tmpItem.nutritions!!.calories
            var sugar: Double? = tmpItem.nutritions!!.sugar

            val intent = Intent(context, ListFruitDetail::class.java)
            intent.putExtra("genus", genus)
            intent.putExtra("name", name)
            intent.putExtra("id", id)
            intent.putExtra("family", family)
            intent.putExtra("order", order)

            intent.putExtra("carbohydrates", carbohydrates)
            intent.putExtra("protein", protein)
            intent.putExtra("fat", fat)
            intent.putExtra("calories", calories)
            intent.putExtra("sugar", sugar)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view){
        val itemName : TextView
        var itemGenus : TextView
        var itemOrder : TextView

        init {
            itemName = view.findViewById(R.id.name)
            itemGenus = view.findViewById(R.id.genus)
            itemOrder = view.findViewById(R.id.order)

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}
