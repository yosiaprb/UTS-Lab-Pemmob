package com.example.utslabpemmob

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utslabpemmob.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inisialisasi binding
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari intent
        val recipientName = intent.getStringExtra("RECIPIENT_NAME")
        val recipientAge = intent.getStringExtra("RECIPIENT_AGE")
        val senderName = intent.getStringExtra("SENDER_NAME")
        val template = intent.getStringExtra("TEMPLATE")

        // Atur tampilan berdasarkan template yang dipilih
        binding.templateBackground.setImageResource(
            if (template == "template1") R.drawable.template1 else R.drawable.template2
        )

        binding.tvMessage.text = "Selamat Ulang Tahun $recipientName yang ke-$recipientAge! " +
                "Semoga harimu menyenangkan. Dari $senderName."

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
