package com.ean.cenaparatodosapp.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ean.cenaparatodosapp.model.Account
import com.ean.cenaparatodosapp.model.Transfer
import com.ean.cenaparatodosapp.model.enum.Type
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class TransferViewModel : ViewModel() {

    private var db = Firebase.firestore
    private val transfers = "transfers"

    val createLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val updateLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val getListLiveData: MutableLiveData<List<Transfer>> by lazy {
        MutableLiveData<List<Transfer>>()
    }

    val deleteLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun create(transfer: Transfer) {
        val docRef = db.collection(transfers)
        docRef.add(transfer.toMap()).addOnSuccessListener {
            createLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("create", it.localizedMessage!!)
            createLiveData.postValue(false)
        }
    }

    fun update(transfer: Transfer) {
        val docRef = db.collection(transfers)
        docRef.document(transfer.id!!).update(transfer.toMap()).addOnSuccessListener {
            updateLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("update", it.localizedMessage!!)
            updateLiveData.postValue(false)
        }
    }

    fun delete(id: String) {
        val docRef = db.collection(transfers)
        docRef.document(id).delete().addOnSuccessListener {
            deleteLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("delete", it.localizedMessage!!)
            deleteLiveData.postValue(false)
        }
    }

    fun getList() {
        val docRef = db.collection(transfers)
        docRef.get().addOnSuccessListener {
            val transfers = ArrayList<Transfer>()
            for (item in it.documents) {
                val transfer = Transfer(item.id,
                    item.data!!["origin"] as Account?,
                    item.data!!["destination"] as Account?,
                    item.data!!["tipo"] as Type?,
                    item.data!!["fecha_movimiento"] as Date?,
                )
                transfers.add(transfer)
            }

            getListLiveData.postValue(transfers)
        }.addOnFailureListener {
            Log.d("get", it.localizedMessage!!)
            getListLiveData.postValue(null)
        }
    }

}
