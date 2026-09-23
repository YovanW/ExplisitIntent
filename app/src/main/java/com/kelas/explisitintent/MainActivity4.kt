package com.kelas.explisitintent

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentPegawai = intent.getParcelableExtra<Pegawai>(
            dataPegawai,
            Pegawai::class.java
        )
        val isiText = "NIP : ${intentPegawai?.NIP.toString()}, " +
                "\nNama : ${intentPegawai?.Nama.toString()}, " +
                "\nDept : ${intentPegawai?.Dept.toString()}"

        val _shopDataPegawai = findViewById<TextView>(R.id.showDataPegawai)

    }

    companion object {
        val dataPegawai = "kirimDataPegawai"

    }
}