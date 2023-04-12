package com.example.laboratorio04viana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.laboratorio04viana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        var name = ""
        var email = ""
        var cel = ""
        //obtener data y meterla en el intent, y hacer la funcion
        binding.btnSave.setOnClickListener {
            name = binding.name.text.toString()
            email = binding.email.text.toString()
            cel = binding.tel.text.toString()

            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("cell", cel)

            startActivity(intent)
        }

    }
}