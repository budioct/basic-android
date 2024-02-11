package com.tutorial

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    /**
     * ini adalah class code untuk Manifest
     * class MainActivity adalah class yang memproses file Manifest.xml (informasi android yang di buat)
     * class AppCompatActivity adalah turunan dari class Activity yang memungkingkan menggunakan fitur baru Android di versi Android lama (Di Rekomendasikan)
     */

    // supaya kita tidak redudance findViewById() setiap kali akses component layout.
    // key word lateinit supaya di kotlin boleh null saat deklarasi variable. bukan nullable TypeData?
    private lateinit var nameEditText: EditText
    private lateinit var sayHelloButton: Button
    private lateinit var sayHelloTextView: TextView

    private fun initComponents() {
        nameEditText = findViewById(R.id.nameEditText) // findViewById() // mendapatkan object dari komponen
        sayHelloButton = findViewById(R.id.sayHelloButton)
        sayHelloTextView = findViewById(R.id.sayHelloTextView)
    }

//    pengecekan fitur dalam konfigurasi apakah perangkat ada perangkat atau tidak
//    Controlling Application Availability 'Programmatic', cek di kode aplikasi kita, jadi pengecekan dilakukan saat aplikasi berjalan
    private fun checkFingerprint(){

        if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)){
            Log.i("FEATURE", "Feature Fingerprint ON")
        } else{
            Log.i("FEATURE", "Feature Fingerprint OFF")
        }
    }

    private fun checkPlatformVersion(){

        Log.i("SDK", Build.VERSION.SDK_INT.toString())
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S){
            Log.i("SDK", "Disabled feature, becaouse version sdk is lower than 31")
        }
    }

    // activity callback, function onCreate() dipanggil ketika activity dibuat
    // (callback function) ketika activity di buat method ini yang akan di eksekusi
    // class R.layout.namaLayoutActivity.xml adalah class yang di generate android untuk di akses method main.kt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // onCreate // Salah satu method yang dipanggil ketika Activity dibuat
        setContentView(R.layout.hello_world) // setContentView() // menampilkan view UI layout

        // tidak di rekomendasikan karna redudance setiap ada layout baru
        // cara mendapatkan View Id dari layout component ---> R.id.sayHelloTextView
        // val nameEditText: EditText  = findViewById(R.id.nameEditText) // findViewById() // mendapatkan object dari komponen
        // val sayHelloButton: Button = findViewById(R.id.sayHelloButton)
        // val sayHelloTextView: TextView = findViewById(R.id.sayHelloTextView)

        // penganti findViewById() yang redudance
        initComponents()

        //sayHelloTextView.text = "Hi" // text // mengakses attribute layout component

        // kita akan get resources
        // Resources getResources() yang digunakan java mengakses resource, di kotlin attribute 'resources'
        // getString() // untuk get class R , string adalah tag yang ada di folder /res/values/strings.xml <resources> <string> </string> </resources>
        sayHelloTextView.text = resources.getString(R.string.app_name)

        // Action Listener untuk proses interaksi layout component ke kode kotlin
        // jadi ketika text di isi value lalu tombol di klik, kemudian tampilkan: Hi name
        sayHelloButton.setOnClickListener {

            // Log
            Log.d("Logger", "This is debug log")
            Log.i("Logger", "This is info log")
            Log.w("Logger", "This is warinig log")
            Log.e("Logger", "This is error log")
            /**
             * hasil dari Log, ketika layout di jalankan
             * 2024-02-09 15:09:42.083 26535-26535 AOM                     com.tutorial                         D  This is debug log
             * 2024-02-09 15:09:42.083 26535-26535 AOM                     com.tutorial                         I  This is info log
             * 2024-02-09 15:09:42.083 26535-26535 AOM                     com.tutorial                         W  This is warinig log
             * 2024-02-09 15:09:42.083 26535-26535 AOM                     com.tutorial                         E  This is error log
             */

            // Log Other Resource, folder /res/values/other.xml
            // Resources getResources() yang digunakan java mengakses resource, di kotlin attribute 'resources'
            Log.i("Value Resource", resources.getBoolean(R.bool.isProductionMode).toString()) // getBoolean() get Class R.type.id  element di layout
            Log.i("Value Resource", resources.getInteger(R.integer.maxPage).toString()) // getInteger() get Class R.type.id  element di layout
            Log.i("Value Resource", resources.getIntArray(R.array.numbers).joinToString(", ")) // getIntArray get Class R.type.id  element di layout
            Log.i("Value Resource", resources.getColor(R.color.background, theme).toString()) // getColor() get Class R.type.id  element di layout
            /**
             * result: get value resource
             * 2024-02-10 09:05:10.608  3788-3788  Value Resource          com.tutorial                         I  true
             * 2024-02-10 09:05:10.608  3788-3788  Value Resource          com.tutorial                         I  100
             * 2024-02-10 09:05:10.608  3788-3788  Value Resource          com.tutorial                         I  100, 200, 300
             * 2024-02-10 09:05:10.609  3788-3788  Value Resource          com.tutorial                         I  -65536
             */

            // akses drawable dari mainActivity
            // resources.getDrawable(R.drawable.sb, theme) // getDrawable() akses class R.drawable.fileName

            // merubah latar background, dari value resource, tidak hardcode
            sayHelloButton.setBackgroundColor(resources.getColor(R.color.background, theme)) // setBackgroundColor() // merubah background button di component layout UI

            val name = nameEditText.text.toString() // text --> Editable getText() // akses text dari layout component lalu di conversi ke String, karna dari awal itu type nya Char
            // sayHelloTextView.text = "Hi $name" // hard code
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name) // hasil serupa dengan line 71, tetapi tidak hard code karna melalui String Resource

            // getStringArray() untuk mengakses String Resource yang array, untuk mengaskes nya dengan class= R.array.name
            resources.getStringArray(R.array.names).forEach {
                Log.i("<string-array>", it)
                /**
                 * hasl dari log, ketika layout di jalankan
                 * 2024-02-09 21:55:49.468 31351-31351 <string-array>          com.tutorial                         I  Budhi
                 * 2024-02-09 21:55:49.468 31351-31351 <string-array>          com.tutorial                         I  Oct
                 * 2024-02-09 21:55:49.468 31351-31351 <string-array>          com.tutorial                         I  22
                 */
            }

            // akses Assets (folder yang tidak di manage oleh android yaitu Resource).. kita tinggal masukan saja ke Assets
            // AssetManager getAssets() atau assets untuk mengakses folder /../assets/
            // InputStream open(@NonNull String fileName) atau open() // membaca file format apapun di dalam folder assets
            // bufferedReader() // membaca setiap charater di file
            // use() // konversi type ke String
            val json = assets.open("sample.json")
                .bufferedReader()
                .use { it.readText() }
            Log.i("Assets Manager", json)
            /**
             * result: ini dari folder main/assets/sample.json
             * 2024-02-10 11:40:13.363 11872-11872 Assets Manager          com.tutorial                         I  {
             *                                                                                                       "firstname" : "budhi",
             *                                                                                                       "lastname" : "oct"
             *                                                                                                     }
             */

            // Raw Resource (lebih aman ketimbang AssetManager),, karna class R.raw.nameFile dan juga mendukung I18N/Localization
            // InputStream openRawResource(@RawRes int id) atau openRawResource() // membaca file format apapun di dalam folder res/row/.
            val sample = resources.openRawResource(R.raw.sample)
                .bufferedReader()
                .use { it.readText() }
            Log.i("Row Resource", sample)
            /**
             * result: ini dari folder res/raw/sample.json
             * 2024-02-10 11:59:15.552 12237-12237 Row Resource            com.tutorial                         I  {
             *                                                                                                       "firstname" : "budhi",
             *                                                                                                       "lastname" : "oct"
             *                                                                                                     }
             * mendukung I18N / localization.. ini dari folder res/raw-in/sample.json
             * 2024-02-10 12:06:58.528 12429-12429 Row Resource            com.tutorial                         I  {
             *                                                                                                       "namaDepan" : "budhi",
             *                                                                                                       "namaBelakang" : "octaviansyah"
             *                                                                                                     }
             */

            // cek perangkat apah punya feature ini yaitu FingerPrint
            // Controlling Application Availability 'Programmatic', cek di kode aplikasi kita, jadi pengecekan dilakukan saat aplikasi berjalan
            checkFingerprint()
            /**
             * result:
             * 2024-02-11 13:47:06.983 13681-13681 FEATURE                 com.tutorial                         I  Feature Fingerprint ON
             */

            // cek perangkat minimun SDK Android, jika level android di bawah targer akan tampil logging, disable feature
            checkPlatformVersion()
            /**
             * result:
             * 2024-02-11 13:57:11.743 13894-13894 SDK                     com.tutorial                         I  25
             * 2024-02-11 13:57:11.743 13894-13894 SDK                     com.tutorial                         I  Disabled feature, becaouse version sdk is lower than 31
             */

        }

    }

}