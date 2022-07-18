package com.ean.cenaparatodosapp.adapter.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ean.cenaparatodosapp.model.Account
import com.ean.cenaparatodosapp.model.Transfer
import com.ean.cenaparatodosapp.model.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class UserViewModel: ViewModel() {

    private var db = Firebase.firestore
    private val users = "users"

    val createLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val updateLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val getListLiveData: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>()
    }

    val deleteLiveData: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun create(user: User) {
        val docRef = db.collection(users)
        docRef.add(user.toMap()).addOnSuccessListener {
            createLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("create", it.localizedMessage!!)
            createLiveData.postValue(false)
        }
    }

    fun update(user: User) {
        val docRef = db.collection(users)
        docRef.document(user.id!!).update(user.toMap()).addOnSuccessListener {
            updateLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("update", it.localizedMessage!!)
            updateLiveData.postValue(false)
        }
    }

    fun delete(id: String) {
        val docRef = db.collection(users)
        docRef.document(id).delete().addOnSuccessListener {
            deleteLiveData.postValue(true)
        }.addOnFailureListener {
            Log.d("delete", it.localizedMessage!!)
            deleteLiveData.postValue(false)
        }
    }

    fun getList() {
        val docRef = db.collection(users)
        docRef.get().addOnSuccessListener {
            val users = ArrayList<User>()
            for (item in it.documents) {
                val user = User(
                    item.id,
                            item.data!!["nombres"] as String?,
                            item.data!!["apellidos"] as String?,
                            item.data!!["tipo_documento"] as String?,
                            item.data!!["documento"] as String?,
                            item.data!!["cuenta"] as Account?,
                            item.data!!["transfers"] as List<Transfer>?,
                            item.data!!["estado"] as Boolean?,
                            item.data!!["fecha_creacion"] as Date?,
                            item.data!!["fecha_modificacion"] as Date?
                )
                users.add(user)
            }

            getListLiveData.postValue(users)
        }.addOnFailureListener {
            Log.d("get", it.localizedMessage!!)
            getListLiveData.postValue(null)
        }
    }

}
