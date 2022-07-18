package com.ean.cenaparatodosapp.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Foundation (
    var id:String?,
    var nombre:String?,
    var tipo_documento:String?,
    var documento:String?,
    var cuenta:Account?,
    var transfers:List<Transfer>?,
    var estado: Boolean?,
    var fecha_creacion: Date?,
    var fecha_modificacion: Date?,
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "nombre" to nombre,
            "tipo_documento" to tipo_documento,
            "documento" to fecha_creacion,
            "cuenta" to cuenta,
            "transfers" to transfers,
            "estado" to estado,
            "fecha_creacion" to fecha_creacion,
            "fecha_modificacion" to fecha_modificacion,
        )
    }
}
