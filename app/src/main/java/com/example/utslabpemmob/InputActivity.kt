package com.example.utslabpemmob

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utslabpemmob.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi binding
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Akses ID dengan binding
        binding.btnNext.setOnClickListener {
            val recipientName = binding.etRecipientName.text.toString()
            val recipientAge = binding.etRecipientAge.text.toString()
            val senderName = binding.etSenderName.text.toString()

            val intent = Intent(this, TemplateSelectionActivity::class.java)
            intent.putExtra("RECIPIENT_NAME", recipientName)
            intent.putExtra("RECIPIENT_AGE", recipientAge)
            intent.putExtra("SENDER_NAME", senderName)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
