package com.ean.cenaparatodosapp.model

import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Account (
    var id:String?,
    var numero:String?,
    var estado: Boolean?,
    var fecha_creacion: Date?,
    var fecha_modificacion: Date?,
){
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "id" to id,
            "numero" to numero,
            "estado" to estado,
            "fecha_creacion" to fecha_creacion,
            "fecha_modificacion" to fecha_modificacion,
        )
    }
}
