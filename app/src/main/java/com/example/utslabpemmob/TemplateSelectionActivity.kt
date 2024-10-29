package com.example.utslabpemmob

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utslabpemmob.databinding.ActivityTemplateSelectionBinding

class TemplateSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTemplateSelectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi binding
        binding = ActivityTemplateSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val recipientName = intent.getStringExtra("RECIPIENT_NAME")
        val recipientAge = intent.getStringExtra("RECIPIENT_AGE")
        val senderName = intent.getStringExtra("SENDER_NAME")

        // Set klik listener pada template
        binding.template1.setOnClickListener {
            openResultActivity(recipientName, recipientAge, senderName, "template1")
        }

        binding.template2.setOnClickListener {
            openResultActivity(recipientName, recipientAge, senderName, "template2")
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun openResultActivity(name: String?, age: String?, sender: String?, template: String) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RECIPIENT_NAME", name)
        intent.putExtra("RECIPIENT_AGE", age)
        intent.putExtra("SENDER_NAME", sender)
        intent.putExtra("TEMPLATE", template)
        startActivity(intent)
    }
}
