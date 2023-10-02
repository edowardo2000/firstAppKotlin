package com.example.edokotlinproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainMenu : AppCompatActivity() {
    lateinit var cardSimulasi: CardView
    lateinit var cardViewBerita: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        intent.getStringExtra("username")

        cardSimulasi = findViewById(R.id.cardGambarMenu)
        cardViewBerita = findViewById(R.id.cardViewBerita)


        cardSimulasi.setOnClickListener(View.OnClickListener {
            intent = Intent (this, SimulasiCicilan::class.java)
            startActivity(intent)
        })

        cardViewBerita.setOnClickListener(View.OnClickListener {
            intent = Intent (this, ListBerita::class.java)
            startActivity(intent)
        })
    }






}