package com.ean.cenaparatodosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ean.cenaparatodosapp.adapter.DonacionesAdapter
import com.ean.cenaparatodosapp.adapter.MovimientoAdapter
import com.ean.cenaparatodosapp.databinding.ActivityHomeFundacionBinding
import com.ean.cenaparatodosapp.databinding.ActivityLoginBinding

class HomeFundacion : AppCompatActivity() {

    private lateinit var binding: ActivityHomeFundacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeFundacionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    fun initRecyclerView(){
        val recyclerView =  binding.recyclerHomeFundacion
        val recyclerViewMovimiento = binding.recyclerHomeFundacionMovimiento


        recyclerView.layoutManager  = LinearLayoutManager(this)
        recyclerView.adapter = DonacionesAdapter(DonacionesProvider.donacionesList)

        recyclerViewMovimiento.layoutManager = LinearLayoutManager(this)
        recyclerViewMovimiento.adapter = MovimientoAdapter(MovimientoProvider.movimientos)
    }
}