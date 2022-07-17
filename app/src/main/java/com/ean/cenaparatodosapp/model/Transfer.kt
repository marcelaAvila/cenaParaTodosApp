package com.ean.cenaparatodosapp.model

import com.ean.cenaparatodosapp.model.enum.Type
import java.util.*

data class Transfer (
    var id:Int,
    var origin:Account,
    var destination:String,
    var tipo: Type,
    var fecha_movimiento: Date
){
}
