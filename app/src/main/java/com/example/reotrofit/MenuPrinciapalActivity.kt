package com.example.reotrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MenuPrinciapalActivity : AppCompatActivity() {

    private lateinit var btnMaestros:Button
    private lateinit var btnAlumnos:Button
    private lateinit var btnCerrarSesion:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_princiapal)

        btnMaestros = findViewById<Button>(R.id.btnMaestros)
        btnAlumnos = findViewById<Button>(R.id.btnAlumnos)
        btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        btnMaestros.setOnClickListener {
            val intent = Intent(this, ProfesorActivity::class.java)
            startActivity(intent)
        }

        btnAlumnos.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCerrarSesion.setOnClickListener {
            Toast.makeText(this, "Sesion Cerrada", Toast.LENGTH_SHORT ).show()

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}