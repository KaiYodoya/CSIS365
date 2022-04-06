package com.csis365.mvpapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csis365.mvpapp.R

class CategoriesAdapter(
    private val categories: List<String>,
    private val categorySelectedCallback: (String) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_category, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = categories[position]
        holder.tvName.setOnClickListener { view ->
            view as TextView
            categorySelectedCallback(view.text.toString())
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tv_name)
    }
}