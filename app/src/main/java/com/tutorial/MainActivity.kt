package com.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * ini adalah class code untuk Manifest
     * class MainActivity adalah class yang memproses file Manifest.xml (informasi android yang di buat)
     * class AppCompatActivity adalah turunan dari class Activity yang memungkingkan menggunakan fitur baru Android di versi Android lama (Di Rekomendasikan)
     */

    // activity callback, function onCreate() dipanggil ketika activity dibuat
    // (callback function) ketika activity di buat method ini yang akan di eksekusi
    // class R.layout.namaLayoutActivity.xml adalah class yang di generate android untuk di akses method main.kt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // onCreate // Salah satu method yang dipanggil ketika Activity dibuat
        setContentView(R.layout.hello_world) // setContentView() // menampilkan view UI layout

        // cara mendapatkan View Id dari layout component ---> R.id.sayHelloTextView
        val nameEditText: EditText  = findViewById(R.id.nameEditText) // findViewById() // mendapatkan object dari komponen
        val sayHelloButton: Button = findViewById(R.id.sayHelloButton)
        val sayHelloTextView: TextView = findViewById(R.id.sayHelloTextView)

        sayHelloTextView.text = "Hi" // text // mengakses attribute layout component

        // Action Listener untuk proses interaksi layout component ke kode kotlin
        // jadi ketika text di isi value lalu tombol di klik, kemudian tampilkan: Hi name
        sayHelloButton.setOnClickListener {
            val name = nameEditText.text.toString() // text --> Editable getText() // akses text dari layout component lalu di conversi ke String, karna dari awal itu type nya Char
            sayHelloTextView.text = "Hi $name"
        }

    }
}