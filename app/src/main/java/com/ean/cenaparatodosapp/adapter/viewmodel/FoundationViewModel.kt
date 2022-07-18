package com.ean.cenaparatodosapp.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ean.cenaparatodosapp.model.Account
import com.ean.cenaparatodosapp.model.Foundation
import com.ean.cenaparatodosapp.model.Transfer
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class FoundationViewModel : ViewModel() {

    private var db = Firebase.firestore
    private val foundations = "foundations"

    val createLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val updateLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val getListLiveData: MutableLiveData<List<Foundation>> by lazy {
        MutableLiveData<List<Foundation>>()
    }

    val deleteLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun create(foundation: Foundation) {
        val docRef = db.collection(foundations)
        docRef.add(foundation.toMap()).addOnSuccessListener {
            createLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("create", it.localizedMessage!!)
            createLiveData.postValue(false)
        }
    }

    fun update(foundation: Foundation) {
        val docRef = db.collection(foundations)
        docRef.document(foundation.id!!).update(foundation.toMap()).addOnSuccessListener {
            updateLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("update", it.localizedMessage!!)
            updateLiveData.postValue(false)
        }
    }

    fun delete(id: String) {
        val docRef = db.collection(foundations)
        docRef.document(id).delete().addOnSuccessListener {
            deleteLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("delete", it.localizedMessage!!)
            deleteLiveData.postValue(false)
        }
    }

    fun getList() {
        val docRef = db.collection(foundations)
        docRef.get().addOnSuccessListener {
            val foundations = ArrayList<Foundation>()
            for (item in it.documents) {
                val foundation = Foundation(item.id,
                        item.data!!["nombre"] as String?,
                    item.data!!["tipo_documento"] as String?,
                    item.data!!["documento"] as String?,
                    item.data!!["cuenta"] as Account?,
                    item.data!!["transfers"] as List<Transfer>?,
                    item.data!!["estado"] as Boolean?,
                    item.data!!["fecha_creacion"] as Date?,
                    item.data!!["fecha_modificacion"] as Date?
                )
                foundations.add(foundation)
            }
            getListLiveData.postValue(foundations)
        }.addOnFailureListener {
            Log.d("get", it.localizedMessage!!)
            getListLiveData.postValue(null)
        }
    }

}
