package com.example.comunicacion_actividades_contratos_especificos

import android.Manifest
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            Toast.makeText(this,"Permiso Concedido",Toast.LENGTH_SHORT).show()
        } else {
            // El permiso fue denegado
            Toast.makeText(this,"Permiso Concedido",Toast.LENGTH_SHORT).show()
        }
    }
    lateinit var boton:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton=findViewById<Button>(R.id.button)
        boton.setOnClickListener {
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)

        }
    }
}