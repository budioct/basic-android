package com.tutorial

import android.app.Application
import android.util.Log

class MyApplication: Application() {

    /**
     * Application
     * Application adalah base class untuk maintain global application state
     * kita bisa buat activity yang lain, dengan extend class Application
     * class ini ada banyak method, kita tinggal override saja method yang kita perlukan
     * contoh: onCreate() --> Dipanggil saat aplikasi dimulai, sebelum aktivitas, layanan, atau objek penerima apa pun (tidak termasuk penyedia konten) dibuat.
     *         jika kita sudah selesai ini tidak akan langsung jalan,
     *         kita perlu registrasikan di Manifest.xml supaya bisa di baca project Application_Android
     *         dengan tag android:".nameActivityApplication"
     */

    override fun onCreate() {
        super.onCreate()
        Log.i("APPLICATION", "Application Created")
        /**
         * result:
         * 2024-02-10 12:56:37.415 12996-12996 APPLICATION             com.tutorial                         I  Application Created
         * 2024-02-10 12:57:26.243 13030-13030 APPLICATION             com.tutorial                         I  Application Created
         */
    }

}