package com.ean.cenaparatodosapp.model

import com.ean.cenaparatodosapp.model.enum.Type
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Transfer (
    var id:String?,
    var origin:Account?,
    var destination:Account?,
    var tipo: Type?,
    var fecha_movimiento: Date?
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "origin" to origin,
            "destination" to destination,
            "tipo" to tipo,
            "fecha_movimiento" to fecha_movimiento,
        )
    }
}
