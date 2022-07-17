package com.ean.cenaparatodosapp.model

import java.util.*

data class Account (
    var id:Int,
    var nombre:String,
    var tipo_documento:String,
    var documento:String,
    var cuenta:Account,
    var estado: Boolean,
    var fecha_creacion: Date,
    var fecha_modificacion: Date,
){

}
