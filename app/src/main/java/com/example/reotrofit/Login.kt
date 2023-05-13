package com.example.reotrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var Resgistrarbtn: Button
    private lateinit var Accederbtn:Button
    private lateinit var etEmail:EditText
    private lateinit var etPass:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Resgistrarbtn=findViewById<Button>(R.id.btnRegistrar)
        Accederbtn=findViewById<Button>(R.id.btnAcceder)
        etEmail= findViewById<EditText>(R.id.emailet)
        etPass=findViewById<EditText>(R.id.passwordet)

        Setup()
    }

    private fun Setup(){
        title="Login"

        Resgistrarbtn.setOnClickListener {
            if(etEmail.text.isNotEmpty() && etPass.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(etEmail.text.toString(), etPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val profesorIntent = Intent(this, ProfesorActivity::class.java)
                            startActivity(profesorIntent)

                        } else {
                            showAlert()
                        }
                    }
            }
        }

        Accederbtn.setOnClickListener {
            if(etEmail.text.isNotEmpty() && etPass.text.isNotEmpty()) {
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(etEmail.text.toString(), etPass.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val profesorIntent = Intent(this, ProfesorActivity::class.java)
                            startActivity(profesorIntent)

                        } else {
                            showAlert()
                        }
                    }
            }
        }
    }

    private  fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog=builder.create()
        dialog.show()
    }
}