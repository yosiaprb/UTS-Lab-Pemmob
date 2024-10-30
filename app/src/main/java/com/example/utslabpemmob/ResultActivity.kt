package com.example.utslabpemmob

import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.TypefaceSpan
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.utslabpemmob.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    @RequiresApi(Build.VERSION_CODES.P)
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

        // Font yang akan digunakan
        val font1 = ResourcesCompat.getFont(this, R.font.happy_birthday)
        val font2 = ResourcesCompat.getFont(this, R.font.rachert)
        val font3 = ResourcesCompat.getFont(this, R.font.coolvetica)
        val font4 = ResourcesCompat.getFont(this, R.font.cream_cake)

        // Buat teks dengan baris baru
        val message = "Selamat Ulang Tahun $recipientName\nyang ke-$recipientAge\nSemoga harimu menyenangkan\nDari $senderName"

        // Membuat SpannableString untuk mengatur gaya
        val spannableString = SpannableString(message)

        // Mengatur gaya dan ukuran untuk setiap bagian teks dengan baris baru
        val firstLineStart = message.indexOf("Selamat Ulang Tahun $recipientName")
        val firstLineEnd = firstLineStart + "Selamat Ulang Tahun $recipientName".length
        spannableString.setSpan(font1?.let { TypefaceSpan(it) }, firstLineStart, firstLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(AbsoluteSizeSpan(36, true), firstLineStart, firstLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // Ukuran font 24sp

        val secondLineStart = message.indexOf("yang ke-$recipientAge")
        val secondLineEnd = secondLineStart + "yang ke-$recipientAge".length
        spannableString.setSpan(font2?.let { TypefaceSpan(it) }, secondLineStart, secondLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(AbsoluteSizeSpan(16, true), secondLineStart, secondLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // Ukuran font 20sp

        val thirdLineStart = message.indexOf("Semoga harimu menyenangkan")
        val thirdLineEnd = thirdLineStart + "Semoga harimu menyenangkan".length
        spannableString.setSpan(font3?.let { TypefaceSpan(it) }, thirdLineStart, thirdLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(AbsoluteSizeSpan(18, true), thirdLineStart, thirdLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // Ukuran font 18sp

        val fourthLineStart = message.indexOf("Dari $senderName")
        val fourthLineEnd = fourthLineStart + "Dari $senderName".length
        spannableString.setSpan(font4?.let { TypefaceSpan(it) }, fourthLineStart, fourthLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(AbsoluteSizeSpan(20, true), fourthLineStart, fourthLineEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE) // Ukuran font 22sp

        // Menetapkan teks yang sudah diatur ke TextView
        binding.tvMessage.text = spannableString

        // Tombol kembali
        binding.backButton.setOnClickListener {
            // Kembali ke TemplateSelectionActivity
            finish() // Mengakhiri ResultActivity dan kembali ke activity sebelumnya
        }


        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
