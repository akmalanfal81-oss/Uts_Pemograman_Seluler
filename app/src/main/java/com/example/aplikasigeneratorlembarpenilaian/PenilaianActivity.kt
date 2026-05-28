package com.example.aplikasigeneratorlembarpenilaian

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PenilaianActivity : AppCompatActivity() {

    private var daftarNilaiKeseluruhan = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penilaian)

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val etNamaMhs = findViewById<EditText>(R.id.etNamaMhs)
        val etRataNilai = findViewById<EditText>(R.id.etRataNilai)
        val btnSimpanHasil = findViewById<Button>(R.id.btnSimpanHasil)
        val tvDaftarNilai = findViewById<TextView>(R.id.tvDaftarNilai)

        val namaDosen = intent.getStringExtra("EXTRA_NAMA_DOSEN") ?: "Tanpa Nama"
        tvGreeting.text = "Halo Dosen, $namaDosen!"

        btnSimpanHasil.setOnClickListener {
            val namaMhs = etNamaMhs.text.toString()
            val nilaiStr = etRataNilai.text.toString()

            if (namaMhs.isNotEmpty() && nilaiStr.isNotEmpty()) {
                val nilai = nilaiStr.toDouble()

                val status = if (nilai >= 80) {
                    "Sangat Baik"
                } else if (nilai >= 60) {
                    "Cukup"
                } else {
                    "Kurang"
                }

                daftarNilaiKeseluruhan += "Nama: $namaMhs | Nilai: $nilai ($status)\n\n"
                tvDaftarNilai.text = daftarNilaiKeseluruhan

                etNamaMhs.text.clear()
                etRataNilai.text.clear()

                Toast.makeText(this, "Data $namaMhs berhasil disimpan!", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Mohon lengkapi Nama Mahasiswa dan Nilai!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}