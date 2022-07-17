package com.ean.cenaparatodosapp.model

import java.util.*

data class Foundation (
    var id:Int,
    var nombre:String,
    var tipo_documento:String,
    var documento:String,
    var cuenta:Account,
    var transfers:List<Transfer>,
    var estado: Boolean,
    var fecha_creacion: Date,
    var fecha_modificacion: Date,
){
}
