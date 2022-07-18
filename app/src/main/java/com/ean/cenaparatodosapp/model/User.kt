package com.ean.cenaparatodosapp.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class User (
    var id:String?,
    var nombres:String?,
    var apellidos:String?,
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
            "nombres" to nombres,
            "apellidos" to apellidos,
            "tipo_documento" to tipo_documento,
            "documento" to documento,
            "cuenta" to cuenta,
            "transfers" to transfers,
            "estado" to estado,
            "fecha_creacion" to fecha_creacion,
            "fecha_modificacion" to fecha_modificacion,
        )
    }
}
