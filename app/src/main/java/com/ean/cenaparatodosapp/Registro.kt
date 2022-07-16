package com.ean.cenaparatodosapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ean.cenaparatodosapp.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registro : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnRegistrarRegistro.setOnClickListener {
            try {
                val correo = binding.EdtvUserRegistro.text.toString()
                val pass = binding.EdtvContrasenaRegistro.text.toString()
                val repeatPass = binding.EdtvRepeatContrasenaRegistro.text.toString()
                if (correo.isEmpty() || pass.isEmpty() || repeatPass.isEmpty()){
                    Toast.makeText(baseContext, "Los campos no pueden estar vacios",
                        Toast.LENGTH_SHORT).show()
                }else{
                    if (!pass.equals(repeatPass)){
                        Toast.makeText(baseContext, "Las contraseñas no coinciden",
                            Toast.LENGTH_SHORT).show()
                    }else{
                        auth.createUserWithEmailAndPassword(correo,pass)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(baseContext, "Usuario Creado",
                                        Toast.LENGTH_SHORT).show()
                                    Log.d(ContentValues.TAG, "signInWithCustomToken:success")// imprimir en la terminal

                                    val intent = Intent(this, Login::class.java)
                                    startActivity(intent)
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(ContentValues.TAG, "signInWithCustomToken:failure", task.exception)//terminal
                                    Toast.makeText(baseContext, "No se pudo registrar el usuario",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                    }
                }
            }catch (e: Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

    }
}