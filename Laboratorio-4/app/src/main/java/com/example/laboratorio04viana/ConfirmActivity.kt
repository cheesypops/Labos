package com.example.laboratorio04viana

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.laboratorio04viana.databinding.ActivityConfirmBinding
import com.example.laboratorio04viana.databinding.ActivityMainBinding

class ConfirmActivity: AppCompatActivity() {
    private lateinit var binding: ActivityConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_confirm)
        binding = ActivityConfirmBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //obtener variables
        val name = intent.getStringExtra("name").toString()
        val email = intent.getStringExtra("email").toString()
        val tel = intent.getStringExtra("cell").toString()

        binding.emailShow.text = email
        binding.nameShow.text = name
        binding.telShow.text = tel

        binding.btnShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Data bien crack $name, $email, $tel.")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }

    }
}