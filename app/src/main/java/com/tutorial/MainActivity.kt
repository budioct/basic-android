package com.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    /**
     * ini adalah class code untuk Manifest
     */

    // (callback function) ketika activity di buat method ini yang akan di eksekusi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // onCreate // Salah satu method yang dipanggil ketika Activity dibuat
        setContentView(R.layout.activity_main) // setContentView() // menampilkan view UI layout
    }
}