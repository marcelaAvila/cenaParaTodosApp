package com.ean.cenaparatodosapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ean.cenaparatodosapp.Movimiento
import com.ean.cenaparatodosapp.databinding.ItemMovimientoBinding


class MovimientoViewHolder(view: View):  RecyclerView.ViewHolder(view){

val binding  = ItemMovimientoBinding.bind(view)
    fun render(movimientoModel: Movimiento){
        binding.txtVFechaMovimientoFundacion.text = movimientoModel.fecha
        binding.txtVMovimientoFundacion.text = movimientoModel.movimiento
        binding.txtVCantidadMovFundacion.text = movimientoModel.valor.toString()
    }

}