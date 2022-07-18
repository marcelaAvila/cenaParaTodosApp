package com.ean.cenaparatodosapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ean.cenaparatodosapp.Donaciones
import com.ean.cenaparatodosapp.databinding.ItemDonacionBinding

class DonacionesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val binding = ItemDonacionBinding.bind(view)

    fun render (donacionesModel: Donaciones){
        binding.txtVFechaDonacionFundacion.text = donacionesModel.fecha
        binding.txtVUsuarioFundacion.text=donacionesModel.usuario
        binding.txtVCantidadFundacion.text=donacionesModel.valor.toString()
        }
    }
