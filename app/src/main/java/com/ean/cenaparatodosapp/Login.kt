package com.ean.cenaparatodosapp

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ean.cenaparatodosapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnIniciarSesionLogin.setOnClickListener {
            try {
                val correo = binding.EdtvUserLogin.text.toString()
                val pass = binding.EdtvContrasenaLogin.text.toString()
                if (correo.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_LONG)
                        .show()
                    throw Exception("Los campos no pueden estar vacios")
                } else {
                    auth.signInWithEmailAndPassword(correo, pass)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(baseContext, "Bienvenido", Toast.LENGTH_SHORT).show()
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(ContentValues.TAG, "signInWithCustomToken:success")
                                val intent = Intent(this, HomeFundacion::class.java)
                                startActivity(intent)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(
                                    ContentValues.TAG,
                                    "signInWithCustomToken:failure",
                                    task.exception
                                )
                                Toast.makeText(
                                    baseContext, "Fallo la autenticacion, valide los datos",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
            catch (e:Exception){
                Toast.makeText(this, e.message,
                    Toast.LENGTH_SHORT).show()
            }
        }
        binding.txtVRegistrarseLogin.setOnClickListener {
            val intent = Intent(this, Registro::class.java)
            startActivity(intent)
        }
    }


}