package com.example.aplikasigeneratorlembarpenilaian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNamaDosen = findViewById<EditText>(R.id.etNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            val namaDosen = etNamaDosen.text.toString()

            if (namaDosen.isNotEmpty()) {
                val intentPindah = Intent(this, PenilaianActivity::class.java)
                intentPindah.putExtra("EXTRA_NAMA_DOSEN", namaDosen)
                startActivity(intentPindah)
            } else {
                Toast.makeText(this, "Nama Dosen wajib diisi!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}