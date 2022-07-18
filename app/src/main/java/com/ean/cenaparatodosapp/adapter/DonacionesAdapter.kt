package com.ean.cenaparatodosapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ean.cenaparatodosapp.Donaciones
import com.ean.cenaparatodosapp.R

class DonacionesAdapter(private val donacionesList: List<Donaciones>) : RecyclerView.Adapter<DonacionesViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonacionesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  DonacionesViewHolder(layoutInflater.inflate(R.layout.item_donacion, parent, false))
    }

    override fun onBindViewHolder(holder: DonacionesViewHolder, position: Int) {
        val item =  donacionesList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int =  donacionesList.size

}