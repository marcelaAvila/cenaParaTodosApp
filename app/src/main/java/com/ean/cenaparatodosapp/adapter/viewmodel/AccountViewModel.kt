package com.ean.cenaparatodosapp.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ean.cenaparatodosapp.model.Account
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class AccountViewModel : ViewModel() {

    private var db = Firebase.firestore
    private val accounts = "accounts"

    val createLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val updateLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val getListLiveData: MutableLiveData<List<Account>> by lazy {
        MutableLiveData<List<Account>>()
    }

    val deleteLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun create(account: Account) {
        val docRef = db.collection(accounts)
        docRef.add(account.toMap()).addOnSuccessListener {
            createLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("create", it.localizedMessage!!)
            createLiveData.postValue(false)
        }
    }

    fun update(account: Account) {
        val docRef = db.collection(accounts)
        docRef.document(account.id!!).update(account.toMap()).addOnSuccessListener {
            updateLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("update", it.localizedMessage!!)
            updateLiveData.postValue(false)
        }
    }

    fun delete(id: String) {
        val docRef = db.collection(accounts)
        docRef.document(id).delete().addOnSuccessListener {
            deleteLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("delete", it.localizedMessage!!)
            deleteLiveData.postValue(false)
        }
    }

    fun getList() {
        val docRef = db.collection(accounts)
        docRef.get().addOnSuccessListener {
            val accounts = ArrayList<Account>()
            for (item in it.documents) {
                val account = Account(
                    item.id,
                    item.data!!["numero"] as String?,
                    item.data!!["estado"] as Boolean?,
                    item.data!!["fecha_creacion"] as Date?,
                    item.data!!["fecha_modificacion"] as Date?
                )
                accounts.add(account)
            }

            getListLiveData.postValue(accounts)
        }.addOnFailureListener {
            Log.d("get", it.localizedMessage!!)
            getListLiveData.postValue(null)
        }
    }

}
