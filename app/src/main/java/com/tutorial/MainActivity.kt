package com.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    /**
     * ini adalah class code untuk Manifest
     * class MainActivity adalah class yang memproses file Manifest.xml (informasi android yang di buat)
     * class AppCompatActivity adalah turunan dari class Activity yang memungkingkan menggunakan fitur baru Android di versi Android lama (Di Rekomendasikan)
     */

    // activity callback, function onCreate() dipanggil ketika activity dibuat
    // (callback function) ketika activity di buat method ini yang akan di eksekusi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // onCreate // Salah satu method yang dipanggil ketika Activity dibuat
        setContentView(R.layout.activity_main) // setContentView() // menampilkan view UI layout
    }
}