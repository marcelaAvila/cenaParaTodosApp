package com.ean.cenaparatodosapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ean.cenaparatodosapp.Movimiento
import com.ean.cenaparatodosapp.R

class MovimientoAdapter (val movimientosList: List<Movimiento> )  : RecyclerView.Adapter<MovimientoViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovimientoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  MovimientoViewHolder(layoutInflater.inflate(R.layout.item_movimiento, parent, false))
    }

    override fun onBindViewHolder(holder: MovimientoViewHolder, position: Int) {
        val item = movimientosList[position]
        holder.render(item)

    }

    override fun getItemCount(): Int = movimientosList.size

}